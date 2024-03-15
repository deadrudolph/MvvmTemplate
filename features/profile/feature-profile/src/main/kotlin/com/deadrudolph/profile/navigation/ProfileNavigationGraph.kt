package com.deadrudolph.profile.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deadrudolph.profile.di.component.ProfileComponentHolder
import com.deadrudolph.profile.presentation.ui.screen.first.FirstProfileScreen
import com.deadrudolph.profile.presentation.ui.screen.second.SecondProfileScreen

fun NavGraphBuilder.addProfileFeatureGraph(popBackStack: () -> Unit) {
    val viewModelFactory = ProfileComponentHolder.getInternal().provideVF()
    navigation(
        startDestination = ProfileNavTarget.ProfileFirstFeature.route.route,
        route = ProfileNavTarget.moduleRoute.route
    ) {
        composable(ProfileNavTarget.ProfileFirstFeature.route.route) {
            FirstProfileScreen(
                viewModel = viewModel(factory = viewModelFactory)
            )
        }
        composable(ProfileNavTarget.ProfileSecondFeature.route.route) {
            SecondProfileScreen(
                viewModel = viewModel(factory = viewModelFactory),
                popBackStack = popBackStack,
            )
        }
    }
}
