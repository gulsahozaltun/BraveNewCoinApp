package com.gulsahozaltun.bravenewcoinapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

//extension
/*fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {
    Glide.with(context).load(url).into(this)}*/



fun placeholderProgressBar(context : Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        centerRadius = 40f
        strokeWidth = 8f
        start()
    }
}

