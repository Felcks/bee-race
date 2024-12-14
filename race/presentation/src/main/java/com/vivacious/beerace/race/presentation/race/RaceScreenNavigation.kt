package com.vivacious.beerace.race.presentation.race

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val RaceScreenRoute = "race_screen_navigation"

fun NavController.navigateToRaceScreen(
    startTime: Int,
    navOptions: NavOptions? = null,
) {
    this.navigate("$RaceScreenRoute/$startTime", navOptions)
}

fun NavGraphBuilder.raceScreen(
    navigateToHomeScreen: () -> Unit,
) {
    composable(
        route = "$RaceScreenRoute/{startTime}",
        arguments = listOf(
            navArgument("startTime") {
                defaultValue = 0
                type = NavType.IntType
            }
        )
    ) {
        RaceScreen(navigateToHomeScreen)
    }
}