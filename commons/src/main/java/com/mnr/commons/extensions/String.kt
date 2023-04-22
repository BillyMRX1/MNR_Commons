package com.mnr.commons.extensions

fun String?.getValueOrEmpty(): String = when (this) {
    null -> ""
    else -> this
}

fun String?.getValueOrDashed(): String = when (this) {
    null -> "-"
    "" -> "-"
    else -> this
}

fun String?.getValueOrZero(): String = when (this) {
    null -> "0"
    "" -> "0"
    else -> this
}

fun String?.getValueOrElse(elseClause: () -> String): String =
    if (this.isNullOrEmpty()) elseClause.invoke()
    else this