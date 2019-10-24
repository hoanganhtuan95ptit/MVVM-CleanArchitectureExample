package net.citigo.kiotviet.pos.fnb.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import citigo.core.ui.BaseAdapter
import citigo.core.util.ScreenUtils
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.item_table.view.*
import net.lab.myapplication.App
import net.lab.myapplication.R
import net.lab.myapplication.data.entities.Image
import net.lab.myapplication.utils.extention.loadData
import java.util.*
import kotlin.math.roundToInt

class ImageAdapter(
    activity: Activity?
) : BaseAdapter<Image>(activity, null, null) {

    companion object {

        private var COL: Int = 0
        private var WIDTH_SCREEN: Int = 0

        private var ITEM_SIZE: Int = 0
        private var ITEM_PADDING: Int = 0
    }

    init {
        ITEM_PADDING = ScreenUtils.dp2px(App.shared, 4f).toInt()
        WIDTH_SCREEN = ScreenUtils.getScreenWidth(App.shared) - 2 * ITEM_PADDING

        COL = (WIDTH_SCREEN / ScreenUtils.dp2px(App.shared, 120f)).roundToInt()

        ITEM_SIZE = WIDTH_SCREEN / COL
    }

    override fun setRecyclerView(recyclerView: RecyclerView) {
        super.setRecyclerView(recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.setPadding(ITEM_PADDING, ITEM_PADDING, ITEM_PADDING, ITEM_PADDING)
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(activity, COL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<Image> {
        return TableHolder.create(parent)
    }


    class TableHolder(itemView: View) :
        ViewHolder<Image>(itemView, null) {

        companion object {

            fun create(
                parent: ViewGroup?
            ): TableHolder {
                val view =
                    LayoutInflater.from(parent?.context).inflate(R.layout.item_table, parent, false)
                view.layoutParams.width = ITEM_SIZE
                view.layoutParams.height = ITEM_SIZE

                view.setPadding(ITEM_PADDING, ITEM_PADDING, ITEM_PADDING, ITEM_PADDING)

                return TableHolder(view)
            }
        }

        override fun bindData(item: Image, items: ArrayList<Image>, position: Int) {
            super.bindData(item, items, position)
            itemView.ivPhoto.loadData(item.url, CenterCrop())
        }
    }
}