package com.mnr.commons.extensions

fun <T> List<T>?.getValueOrEmpty(): List<T> = this ?: listOf()

fun <T> merge(first: List<T>, second: List<T>): List<T> = first + second