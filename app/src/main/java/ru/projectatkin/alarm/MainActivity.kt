package ru.projectatkin.alarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.fragment.app.FragmentActivity
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import ru.projectatkin.alarm.ui.theme.AlarmTheme
import java.util.*

class MainActivity : ComponentActivity(), TimePickerDialog.OnTimeSetListener {
    var minute = 0
    var hour = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AlarmTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun getDataTimeCalendar() {
        var calendar = Calendar.getInstance()
        minute = calendar.get(Calendar.MINUTE)
        hour = calendar.get(Calendar.HOUR)
    }

    fun pickTime() {
        getDataTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(p0: TimePicker?, hourSet: Int, minuteSet: Int) {
        this.minute = minuteSet
        this.hour = hourSet

    }



    private fun materialTimePicker() {
        var calendar = Calendar.getInstance()
        val materialTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Выберите время будильника")
            .build()

        materialTimePicker.addOnPositiveButtonClickListener {
            calendar = Calendar.getInstance()
            calendar.set(Calendar.MILLISECOND, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MINUTE, materialTimePicker.minute)
            calendar.set(Calendar.HOUR, materialTimePicker.hour)

            val alarmManager: AlarmManager =
                getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val alarmClockInfo = AlarmManager.AlarmClockInfo(
                calendar.timeInMillis,
                getAlarmInfoPendingIntent()
            )

            //Toast.makeText(this, "Будильник установлен", Toast.LENGTH_LONG).show()

            alarmManager.setAlarmClock(alarmClockInfo, getAlarmActionPendingIntent())
        }

        val supportFragmentManager =

            materialTimePicker.show(child)
//                materialTimePicker.show(
//                    (this@MainActivity as FragmentActivity).supportFragmentManager, "tag_picker"
//                )
    }

    private fun getAlarmInfoPendingIntent(): PendingIntent {
        val alarmInfoIntent = Intent(this, MainActivity::class.java)
        alarmInfoIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        return PendingIntent.getActivity(
            this,
            0,
            alarmInfoIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    private fun getAlarmActionPendingIntent(): PendingIntent {
        intent = Intent(this, AlarmPlaying()::class.java)

        return PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }


}

//
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    AlarmTheme {
//        Greeting("Android")
//    }
//}