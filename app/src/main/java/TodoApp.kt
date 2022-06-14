package com.todo.todolist

import android.app.Application
import com.google.firebase.FirebaseApp
import com.todo.core.log.LogFileLogger
import com.todo.todolist.di.appModules
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TodoApp : Application() {

    private val logger: LogFileLogger by inject()

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initFirebase()
        initFileLogger()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(applicationContext)
            modules(appModules)
        }
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(applicationContext)
    }

    private fun initFileLogger() {
        logger.initFileLogger(applicationContext, BuildConfig.VERSION_NAME)
    }
}