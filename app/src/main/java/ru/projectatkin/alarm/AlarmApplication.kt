package ru.projectatkin.alarm

import android.app.Application
import android.content.Context

class AlarmApplication(): Application() {
    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun getAppContext(): Context {
        return context
    }
}