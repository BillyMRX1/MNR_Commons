package com.mnr.commons.extensions

fun Int?.getValueOrZero(): Int = this ?: 0

fun Int?.getPositiveValue(): Int? = if ((this ?: 0) <= 0) this?.times(-1) else this