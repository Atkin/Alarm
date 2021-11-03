package ru.projectatkin.alarm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import ru.projectatkin.alarm.MainActivity
import java.util.*

@Composable
fun homeScreen(navController: NavController) {
        var calendar = Calendar.getInstance()
        var minuteFinal by remember { mutableStateOf(Calendar.MINUTE) }
        var hourFinal by remember { mutableStateOf(Calendar.HOUR) }


        Column() {
            Button(onClick = {
                MainActivity().pickTime()
                //pickTime()
            }) {
                Text(text = "Press me")
            }

            Button(onClick = {
                //minuteFinal = minute
                //hourFinal = hour
                //nav
            }) {
                Text(text = "Start")
            }
            Text(text = "$hourFinal:$minuteFinal")

        }



}