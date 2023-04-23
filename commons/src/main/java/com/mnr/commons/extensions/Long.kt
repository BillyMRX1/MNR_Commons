package com.mnr.commons.extensions

fun Long?.getValueOrZero(): Long = this ?: 0L

fun Long?.getPositiveValue(): Long? = if ((this ?: 0) <= 0L) this?.times(-1) else this

