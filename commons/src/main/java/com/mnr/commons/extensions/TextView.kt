package com.mnr.commons.extensions

import android.widget.TextView
import androidx.core.content.ContextCompat

fun TextView.setCompatText(stringId: Int) {
    this.text = resources.getString(stringId)
}

fun TextView.setCompatColor(colorId: Int) {
    val context = this.context
    this.setTextColor(ContextCompat.getColor(context, colorId))
}

