package com.mnr.commons.extensions

fun Double?.getValueOrZero(): Double = this ?: 0.0

fun Double.toFloatFloored(): Float {
    val numberPrecisionRemoved = this.toInt()
    return numberPrecisionRemoved.toFloat()
}

fun Double?.getPositiveValue(): Double? = if ((this ?: 0.0) <= 0.0) this?.times(-1.0) else this