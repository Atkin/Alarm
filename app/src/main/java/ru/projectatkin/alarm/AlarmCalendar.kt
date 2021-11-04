package ru.projectatkin.alarm

import android.app.TimePickerDialog
import android.content.Context
import android.widget.TimePicker
import java.util.*

class AlarmCalendar() : TimePickerDialog.OnTimeSetListener {
    var minute: Int = 0
        set(value) {
            field = value
        }
        get() = field

    var hour: Int = 0
        set(value) {
            field = value
        }
        get() = field

    private fun getDataTimeCalendar() {
        var calendar = Calendar.getInstance()
        minute = calendar.get(Calendar.MINUTE)
        hour = calendar.get(Calendar.HOUR)
    }

    fun pickTime(context: Context) {
        getDataTimeCalendar()
        TimePickerDialog(context, this, hour, minute, true).show()
    }

    override fun onTimeSet(p0: TimePicker?, hourSet: Int, minuteSet: Int) {
        minute = minuteSet
        hour = hourSet
    }
}