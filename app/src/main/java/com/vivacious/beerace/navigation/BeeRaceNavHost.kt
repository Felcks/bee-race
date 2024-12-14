package com.vivacious.beerace.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vivacious.beerace.race.presentation.home.HomeScreenRoute
import com.vivacious.beerace.race.presentation.home.homeScreen

@Composable
fun BeeRaceNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute,
        modifier = modifier
    ) {
        homeScreen()
    }
}