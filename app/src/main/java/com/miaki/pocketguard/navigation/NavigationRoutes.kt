package com.miaki.pocketguard.navigation

sealed class Screen(
    val route: String
) {
    data object DASHBOARD : Screen("dashboard")
    data object POST : Screen("post")
}