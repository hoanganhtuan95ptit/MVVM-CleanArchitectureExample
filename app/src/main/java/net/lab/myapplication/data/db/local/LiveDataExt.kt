package net.lab.myapplication.data.db.local

import androidx.lifecycle.LiveData

class LiveDataExt<T>(private var oldValue: T? = null) : LiveData<T>(), LiveDataBehavior<T> {
    override fun setOldValue(value: T?) {
        oldValue = value
    }
    override fun getOldValue(): T? {
        return oldValue
    }
    public override fun postValue(value: T) {
        super.postValue(value)
    }
    public override fun setValue(value: T) {
        super.setValue(value)
        setOldValue(value)
    }
}
interface LiveDataBehavior<T> {
    fun setOldValue(value: T?)
    fun getOldValue(): T?
}