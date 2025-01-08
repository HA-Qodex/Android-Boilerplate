package com.miaki.pocketguard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miaki.pocketguard.view.DashboardView
import com.miaki.pocketguard.view.PostView

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController, startDestination = Screen.DASHBOARD.route
    ) {
        composable(Screen.DASHBOARD.route) {
            DashboardView(navController = navigationController)
        }
        composable(Screen.POST.route) {
            PostView(navigationController)
        }
        }
}