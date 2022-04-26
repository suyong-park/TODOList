package com.todo.presentation.ui.common

import android.content.Context
import android.widget.Toast

class ToastEvent {

    private var message: String? = null
    private var messageResId: Int? = null

    fun show(context: Context, isShort: Boolean = true) {
        val duration = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
        val message = messageResId?.let { context.getString(it) } ?: this.message

        Toast.makeText(context, message, duration).show()
    }

    companion object {
        fun fromString(msgStr: String): ToastEvent {
            return ToastEvent().apply { this.message = msgStr }
        }

        fun fromResId(resId: Int): ToastEvent {
            return ToastEvent().apply { this.messageResId = resId }
        }
    }
}