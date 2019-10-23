package net.lab.myapplication.data.db

import android.os.Looper
import androidx.annotation.MainThread
import androidx.collection.ArraySet
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class LocalResult<T>(private var mEvent: String, private var mAction: Action<T>?) :
    LiveData<T>() {

    companion object {
        fun <T> create(event: String, query: (LocalResult<T>) -> T): LocalResult<T> {
            return LocalResult(
                event,
                object : Action<T> {
                    override fun doInBackground(localResult: LocalResult<T>): T {
                        return query(localResult)
                    }
                })
        }
    }

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private val observers = HashMap<Observer<in T>, LifecycleOwner>()

    init {
        handler()
    }

    private var observer = Observer<Any> {
        handler()
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)
        observers[observer] = owner
        LocalResultNotification.init()
            .addListener(mEvent, owner, this.observer)
    }

    override fun removeObserver(observer: Observer<in T>) {
        super.removeObserver(observer)
        observers.remove(observer)
        LocalResultNotification.init()
            .removeListener(mEvent, this.observer)
    }

    fun clone(localResult: LocalResult<T>) {
        this.mEvent = localResult.mEvent
        this.mAction = localResult.mAction
        postValue(localResult.value)
    }

    fun copy(localResult: LocalResult<T>) {
        this.mEvent = localResult.mEvent
        this.mAction = localResult.mAction
        postValue(localResult.value)
    }

    private fun handler() {
        if (mAction == null) return
        if (Thread.currentThread().id == Looper.getMainLooper().thread.id) {// thread main
            mCompositeDisposable.add(
                Observable.just(this)
                    .map<T> { r ->
                        mAction?.doInBackground(r)
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ v ->
                        postValue(v)
                    }, {
                        postValue(null)
                    }, { }, { })
            )
        } else {// thread background
            postValue(mAction?.doInBackground(this))
        }
    }

    interface Action<T> {
        fun doInBackground(localResult: LocalResult<T>): T
    }

    open class LocalResultNotification {

        companion object {
            private var instance: LocalResultNotification? = null

            fun init(): LocalResultNotification {
                if (instance == null) {
                    synchronized(LocalResultNotification::class.java) {
                        val inst =
                            instance
                        if (inst == null) {
                            synchronized(LocalResultNotification::class.java) {
                                instance =
                                    LocalResultNotification()
                            }
                        }
                    }
                }
                return instance!!
            }

            fun <T : Any> notification(t: T) {
                notification(
                    t.javaClass
                )
            }

            fun <T : Any> notification(ts: Collection<T>) {
                if (ts.isNotEmpty()) return
                notification(
                    ts.iterator().next().javaClass
                )
            }

            fun <T : Any> notification(clazz: Class<T>) {
                notification(
                    clazz.name,
                    clazz.name
                )
                notification(
                    clazz.canonicalName,
                    clazz.canonicalName
                )
            }

            fun notification(event: String?, data: Any?) {
                init()
                    .notification(event, data)
            }
        }

        private val map = HashMap<String, LiveEvent<Any>>()

        fun notification(event: String?, data: Any?) {
            val liveData = map[event]
            liveData?.postValue(data)
        }

        fun addListener(event: String, owner: LifecycleOwner, observer: Observer<Any>) {
            var liveData = map[event]

            if (liveData == null) {
                liveData = LiveEvent()
            }
            liveData.observe(owner, observer)

            map[event] = liveData
        }

        fun removeListener(event: String, observer: Observer<Any>) {
            val liveData = map[event]

            liveData?.removeObserver(observer)

            if (liveData != null && !liveData.hasObservers()) {
                map.remove(event)
            }
        }

        class LiveEvent<T> : MediatorLiveData<T>() {

            private val observers = ArraySet<ObserverWrapper<in T>>()

            @MainThread
            override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
                val wrapper = ObserverWrapper(observer)
                observers.add(wrapper)
                super.observe(owner, wrapper)
            }

            @MainThread
            override fun removeObserver(observer: Observer<in T>) {
                if (observers.remove(observer as? ObserverWrapper<in T>)) {
                    super.removeObserver(observer)
                    return
                }
                val iterator = observers.iterator()
                while (iterator.hasNext()) {
                    val wrapper = iterator.next()
                    if (wrapper.observer == observer) {
                        iterator.remove()
                        super.removeObserver(wrapper)
                        break
                    }
                }
            }

            @MainThread
            override fun setValue(t: T?) {
                observers.forEach { it.newValue() }
                super.setValue(t)
            }

            private class ObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {

                private var pending = false

                override fun onChanged(t: T?) {
                    if (pending) {
                        pending = false
                        observer.onChanged(t)
                    }
                }

                fun newValue() {
                    pending = true
                }
            }
        }
    }

}

