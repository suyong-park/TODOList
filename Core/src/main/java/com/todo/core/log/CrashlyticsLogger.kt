package com.todo.core.log

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class CrashlyticsLogger : Logger {

    private val crashlytics = Firebase.crashlytics

    override fun error(tag: String, msg: String, throwable: Throwable?) {
        crashlytics.log("Error [$tag] $msg $throwable")
    }

    override fun warning(tag: String, msg: String) {
        crashlytics.log("Warning [$tag] $msg")
    }

    override fun debug(tag: String, msg: String) {
        crashlytics.log("Debug [$tag] $msg")
    }

    override fun info(tag: String, msg: String) {
        crashlytics.log("Info [$tag] $msg")
    }
}