package net.lab.myapplication.utils.extention

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import net.lab.myapplication.R

fun ImageView.loadData(path: String, vararg transformations: Transformation<Bitmap>) {
    Glide.with(context)
        .asBitmap()
        .load(path)
        .error(R.drawable.ic_image)
        .transition(BitmapTransitionOptions.withCrossFade(500))
        .transform(MultiTransformation(*transformations))
        .into(this)
}