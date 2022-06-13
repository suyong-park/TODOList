package com.todo.presentation.ext

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String, isShort: Boolean = false) {
    val duration = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    Toast.makeText(this, msg, duration).show()
}