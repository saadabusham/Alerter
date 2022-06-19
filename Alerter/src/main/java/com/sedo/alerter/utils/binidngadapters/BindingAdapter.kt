package com.sedo.alerter.utils.binidngadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textColorRes")
fun TextView.textColorRes(
    color: Int
) {
    setTextColor(context.getColor(color))
}

@BindingAdapter("backgroundRes")
fun View?.setBackgroundColorRes(color: Int) {
    this?.setBackgroundColor(context.getColor(color))
}