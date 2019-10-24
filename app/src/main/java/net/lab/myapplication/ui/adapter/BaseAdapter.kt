package citigo.core.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<T> @JvmOverloads constructor(
    protected var activity: Activity?,
    protected var mOnItemListener: OnItemListener<T>?,
    protected var onLoadMoreListener: OnLoadMoreListener?
) : RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {

    private var numberHolderLoadMore = 3

    var items = ArrayList<T>()
    var mLayoutInflater: LayoutInflater = LayoutInflater.from(activity)

    lateinit var mRecyclerView: RecyclerView

    open fun setRecyclerView(recyclerView: RecyclerView) {
        mRecyclerView = recyclerView
        mRecyclerView.adapter = this
        mRecyclerView.layoutManager = getLayoutManager()
    }

    open fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(activity)
    }

    fun bindData(results: List<T>) {
        items.clear()
        items.addAll(results)
        notifyDataSetChanged()
    }

    fun update(item: T) {
        val position = items.indexOf(item)
        if (position < 0) return
        items[position] = item
        notifyItemChanged(position, item)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int, payloads: List<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, ArrayList(payloads))
        } else {
            holder.bindData(items[position], items, position, payloads)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bindData(items[position], items, position)
    }

    override fun onViewAttachedToWindow(holder: ViewHolder<T>) {
        super.onViewAttachedToWindow(holder)
        val position = holder.adapterPosition
        if (itemCount - numberHolderLoadMore < position && onLoadMoreListener != null) {
            onLoadMoreListener!!.onLoadMore()
        }
    }

    override fun onViewRecycled(holder: ViewHolder<T>) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    abstract class ViewHolder<T> @JvmOverloads constructor(
        itemView: View,
        var mOnItemListener: OnItemListener<T>? = null
    ) : RecyclerView.ViewHolder(itemView) {

        protected var mItem: T? = null

        init {
            itemView.setOnClickListener {
                mItem?.let {
                    onClicked(it)
                    if (mOnItemListener != null) {
                        mOnItemListener!!.onItemClicked(it, adapterPosition)
                    }
                }
            }
        }

        open fun bindData(item: T, items: ArrayList<T>, position: Int, payloads: List<Any>) {
            mItem = item
        }

        open fun bindData(item: T, items: ArrayList<T>, position: Int) {
            mItem = item
        }

        fun onViewRecycled() {}

        protected open fun onClicked(item: T) {

        }
    }

    open interface OnLoadMoreListener {
        open fun onLoadMore()
    }

    open interface OnItemListener<T> {
        open fun onItemClicked(item: T, position: Int)
    }

}
