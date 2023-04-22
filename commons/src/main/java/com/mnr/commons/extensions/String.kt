package com.mnr.commons.extensions

fun String?.getValueOrEmpty(): String = when (this) {
    null -> ""
    else -> this
}