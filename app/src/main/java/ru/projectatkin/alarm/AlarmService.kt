package ru.projectatkin.alarm

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

@Suppress("DEPRECATION")
class AlarmService : Service() {
    override fun onCreate() {
        Toast.makeText(this, "AlarmService.onCreate()", Toast.LENGTH_LONG).show();
        super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "AlarmService.onBind()", Toast.LENGTH_LONG).show();
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "AlarmService.onDestroy()", Toast.LENGTH_LONG).show()
    }
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this, "AlarmService.onStart()", Toast.LENGTH_LONG).show()
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Toast.makeText(this, "AlarmService.onUnbind()", Toast.LENGTH_LONG).show()
        return super.onUnbind(intent)
    }
}