package com.mnr.commons.extensions

import android.text.Html
import android.util.Patterns

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

fun String.setNullIfEmpty(): String? = this.ifEmpty { null }

fun String.convertFromHtmlToString(): String = Html.fromHtml(this).toString()

fun String.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

