package ru.projectatkin.alarm

import android.content.Context
import android.media.RingtoneManager
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class AlarmPlaying() {

    @Composable
    fun AlarmPlaying() {
        var notificationRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        var ringtone = RingtoneManager.getRingtone(AlarmApplication().getAppContext(), notificationRingtone)
        if(ringtone==null) {
            notificationRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            ringtone = RingtoneManager.getRingtone(AlarmApplication().getAppContext(), notificationRingtone)
        }
        if(ringtone != null) {
            ringtone.play()
        }

        Button(onClick = {
            if(ringtone != null && ringtone.isPlaying) {
                ringtone.stop()
            }
        }) {
            Text(text = "Stop")
        }
    }
}