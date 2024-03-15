package com.deadrudolph.template_mvvm.navigation.host

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.deadrudolph.home.navigation.addHomeFeatureGraph
import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile.navigation.addProfileFeatureGraph
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun NavigationComponent(
    navController: NavHostController,
    navigator: Navigator,
) {
    /**
     * With LaunchedEffect we create a CoroutineScope that is started as soon as our composable
     * component is created STATE
     * and canceled as soon as the composable exits composition.
     * As a result, whenever Navigator.navigateTo() is called, this snippet listens to it and
     * performs the actual transition.
     */
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            navController.navigate(it.route) {
                popUpTo(it.route) // To make sure there is a single route instance in the stack
            }
        }.launchIn(this)
    }

    // Navigation Directions
    NavHost(
        navController = navController,
        startDestination = GlobalNavTarget.HomeModule.target.route
    ) {
        addHomeFeatureGraph { navController.popBackStack() }
        addProfileFeatureGraph { navController.popBackStack() }
    }
}
