package com.vivacious.beerace.race.presentation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivacious.beerace.race.domain.models.Bee
import com.vivacious.beerace.race.presentation.models.BeeModel

const val HomeScreenRoute = "home_screen_navigation"

fun NavController.navigateToHomeScreen(
    bee: Bee?,
    navOptions: NavOptions? = null,
) {
    bee?.let {
        val model = BeeModel.fromAdapter(it)
        this.previousBackStackEntry?.savedStateHandle?.set("winner", model)
        popBackStack()
    } ?:  this.navigate(HomeScreenRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToRaceScreen: (startTime: Int) -> Unit,
) {
    composable(
        HomeScreenRoute
    ) { backstackEntry ->
        val winner : BeeModel? = backstackEntry
            .savedStateHandle["winner"]

        HomeScreen(navigateToRaceScreen, winner)
    }
}