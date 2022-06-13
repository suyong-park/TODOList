package com.todo.core.log

class CombinedLogger(private val loggers: List<Logger>) : Logger {
    override fun error(tag: String, msg: String, throwable: Throwable?) {
        loggers.forEach { it.error(tag, msg, throwable) }
    }

    override fun warning(tag: String, msg: String) {
        loggers.forEach { it.warning(tag, msg) }
    }

    override fun debug(tag: String, msg: String) {
        loggers.forEach { it.debug(tag, msg) }
    }

    override fun info(tag: String, msg: String) {
        loggers.forEach { it.info(tag, msg) }
    }
}