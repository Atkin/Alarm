package ru.projectatkin.alarm

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.projectatkin.alarm.screens.homeScreen

@Composable
fun navigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.homeScreen.route) {
        composable(route = Screens.homeScreen.route) {
            homeScreen(navController = navController, context = context)
        }
        composable(route = Screens.AlarmPlaying.route) {
            AlarmPlaying()
        }
    }
}
