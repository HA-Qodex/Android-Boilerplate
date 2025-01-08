package com.miaki.pocketguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miaki.pocketguard.navigation.AppNavigation
import com.miaki.pocketguard.ui.theme.PocketGuardTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketGuardTheme(darkTheme = false) {
                AppNavigation()
            }
        }
    }
}