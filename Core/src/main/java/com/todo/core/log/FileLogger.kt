package com.todo.core.log

import android.content.Context

interface FileLogger : Logger {
    fun initFileLogger(context: Context, version: String)
}