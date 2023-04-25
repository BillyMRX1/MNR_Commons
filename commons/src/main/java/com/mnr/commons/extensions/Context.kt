package com.mnr.commons.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.dialPhoneNumber(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    startActivity(intent)
}