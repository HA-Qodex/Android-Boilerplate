package com.miaki.pocketguard.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.miaki.pocketguard.navigation.Screen

@Composable
fun DashboardView(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            Button(onClick = { navController.navigate(Screen.POST.route) }) {
                Text("Post")
            }
        }
    }
}