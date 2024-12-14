package com.vivacious.beerace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vivacious.beerace.core.presentation.theme.BeeRaceTheme
import com.vivacious.beerace.navigation.BeeRaceNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeeRaceTheme {
                BeeRaceNavHost()
            }
        }
    }
}