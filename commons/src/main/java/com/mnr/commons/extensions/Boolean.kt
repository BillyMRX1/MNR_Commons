package com.mnr.commons.extensions

fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true