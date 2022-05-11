package com.todo.core.log

import android.content.Context

class LogFileLogger : FileLogger {
    override fun initFileLogger(context: Context, version: String) {

    }

    override fun error(tag: String, msg: String, throwable: Throwable?) {

    }

    override fun warning(tag: String, msg: String) {

    }

    override fun debug(tag: String, msg: String) {

    }

    override fun info(tag: String, msg: String) {

    }
}