package com.deadrudolph.profile.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.deadrudolph.profile.di.component.ProfileComponentHolder
import com.deadrudolph.profile.presentation.ui.screen.first.FirstProfileScreen
import com.deadrudolph.profile.presentation.ui.screen.second.SecondProfileScreen

fun NavGraphBuilder.addProfileFeatureGraph(popBackStack: () -> Unit) {
    val viewModelFactory = ProfileComponentHolder.getInternal().provideVF()
    val userIdKey = "userId"

    navigation(
        startDestination = ProfileNavTarget.ProfileFirstFeature.route.route,
        route = ProfileNavTarget.moduleRoute.route
    ) {
        composable(ProfileNavTarget.ProfileFirstFeature.route.route) {
            FirstProfileScreen(
                viewModel = viewModel(factory = viewModelFactory)
            )
        }
        composable(
            route = "${ProfileNavTarget.ProfileSecondFeature.route.route}/{$userIdKey}",
            arguments = listOf(navArgument(userIdKey) { type = NavType.StringType })
        ) { entry ->
            SecondProfileScreen(
                viewModel = viewModel(factory = viewModelFactory),
                popBackStack = popBackStack,
                userId = entry.arguments?.getString(userIdKey, "").orEmpty()
            )
        }
    }
}
