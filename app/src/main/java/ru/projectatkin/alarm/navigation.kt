package ru.projectatkin.alarm

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ChoiseMusicTheme.route) {
        composable(route = Screens.AlarmPlaying.route) {
            AlarmPlaying()
        }
    }
}
