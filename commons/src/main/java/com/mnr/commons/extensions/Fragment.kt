package com.mnr.commons.extensions

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import timber.log.Timber

fun Fragment.hideKeyboard() {
    try {
        val imm = this.requireContext()
            .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.requireView().windowToken, 0)
    } catch (exception: Exception) {
        Timber.e(exception)
    }
}

fun Fragment.showKeyboard(editText: EditText) {
    try {
        editText.requestFocus()
        val imm = this.requireContext()
            .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    } catch (exception: Exception) {
        Timber.e(exception)
    }
}

fun Fragment.simpleName(): String = this::class.java.simpleName