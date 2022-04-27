package com.todo.core.log

interface Logger {
    fun error(tag: String, msg: String, throwable: Throwable?)
    fun warning(tag: String, msg: String)
    fun debug(tag: String, msg: String)
    fun info(tag: String, msg: String)
}