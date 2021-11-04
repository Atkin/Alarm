package ru.projectatkin.alarm.screens

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import ru.projectatkin.alarm.AlarmCalendar
import ru.projectatkin.alarm.AlarmService
import ru.projectatkin.alarm.MainActivity
import java.util.*

@Composable
fun homeScreen(navController: NavController, context: Context) {
    var calendar = Calendar.getInstance()
    var minuteFinal by remember { mutableStateOf(Calendar.MINUTE) }
    var hourFinal by remember { mutableStateOf(Calendar.HOUR) }
    lateinit var pendingIntent: PendingIntent

    var alarmCalendar = AlarmCalendar()


    Column() {
        Button(
            onClick = {
                alarmCalendar.pickTime(context)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Set alarm time")
        }

        Button(
            onClick = {
                minuteFinal = alarmCalendar.minute
                hourFinal = alarmCalendar.hour
                val myIntent = Intent(context, AlarmService::class.java)
                pendingIntent = PendingIntent.getService(context, 0, myIntent, 0)
                val alarmManager: AlarmManager =
                    context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
                calendar.set(Calendar.MILLISECOND, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MINUTE, alarmCalendar.minute)
                calendar.set(Calendar.HOUR, alarmCalendar.hour)

                //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
                Toast.makeText(context, "Starting Service Alarm", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Start")
        }
        Button(
            onClick = {
                val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
                alarmManager.cancel(pendingIntent)
                Toast.makeText(context, "Service Cancelled", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Stop")
        }
        Text(text = "$hourFinal:$minuteFinal")

    }


}