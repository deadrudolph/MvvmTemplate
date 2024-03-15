package com.deadrudolph.home.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deadrudolph.home.di.component.HomeComponentHolder
import com.deadrudolph.home.presentation.ui.screen.home.HomeScreen

@Suppress("UnusedParameter")
fun NavGraphBuilder.addHomeFeatureGraph(popBackStack: () -> Unit) {
    navigation(
        startDestination = HomeNavTarget.HomeFirstFeature.route.route,
        route = HomeNavTarget.moduleRoute.route,
    ) {
        composable(HomeNavTarget.HomeFirstFeature.route.route) {
            val factory = HomeComponentHolder.getInternal().provideVF()
            HomeScreen(
                homeViewModel = viewModel(factory = factory)
            )
        }
    }
}
