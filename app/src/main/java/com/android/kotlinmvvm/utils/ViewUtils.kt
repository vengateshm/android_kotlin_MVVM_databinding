package com.android.kotlinmvvm.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

fun Context.showToast(message: String) {
    Toast.makeText(this, message, LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}