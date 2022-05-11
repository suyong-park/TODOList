package com.todo.core.log

import android.util.Log

class AndroidLogger : Logger {
    override fun error(tag: String, msg: String, throwable: Throwable?) {
        Log.e(tag, "$msg\n${throwable?.message}")
    }

    override fun warning(tag: String, msg: String) {
       Log.w(tag, msg)
    }

    override fun debug(tag: String, msg: String) {
       Log.d(tag, msg)
    }

    override fun info(tag: String, msg: String) {
       Log.i(tag, msg)
    }
}