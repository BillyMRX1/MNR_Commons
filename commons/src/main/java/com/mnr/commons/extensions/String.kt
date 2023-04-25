package com.mnr.commons.extensions

import android.os.Build
import android.text.Html
import android.util.Patterns
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

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

fun String.capitalizeWords(): String {
    return lowercase(Locale.ROOT).
    split(" ").
    joinToString(" ")
    { string->
        string.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }
}

fun insertChar(str: String, padding: Char, position: Int): String {
    val stringBuilder = StringBuilder(str)
    stringBuilder.insert(position, padding)
    return stringBuilder.toString()
}

fun String.timeStampToDate(dateFormat: String) : String {
    return if (!this.isNullOrEmpty()) {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        val stampDate = Date(this.toLong() * 1000L)
        sdf.format(stampDate)
    } else {
        "-"
    }
}

fun String.changeDateFormat(currentDateFormat: String?, newDateFormat: String?): String {
    val calendar = Calendar.getInstance()

    val sdf = SimpleDateFormat(currentDateFormat, Locale.getDefault())
    calendar.time = sdf.parse(this) as Date
    val sdfShow = SimpleDateFormat(newDateFormat, Locale.getDefault())
    return sdfShow.format(calendar.time)
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.ChangeDateFormatWithoutFormat(newDateFormat: String?): String {
    val parsedDate = LocalDate.parse(this)
    val formatter = DateTimeFormatter.ofPattern(newDateFormat)
    return parsedDate.format(formatter)
}