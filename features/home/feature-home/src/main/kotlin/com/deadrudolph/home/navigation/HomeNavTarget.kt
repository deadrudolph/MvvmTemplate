package com.deadrudolph.home.navigation

import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.NavTarget

internal sealed class HomeNavTarget(
    val route: NavTarget
) {
    data object HomeFirstFeature : HomeNavTarget(route = NavTarget("home_first_feature"))

    companion object {

        val moduleRoute: NavTarget = GlobalNavTarget.HomeModule.target
    }
}
