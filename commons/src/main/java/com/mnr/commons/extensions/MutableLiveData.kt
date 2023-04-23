package com.mnr.commons.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.asImmutable(): LiveData<T> = this