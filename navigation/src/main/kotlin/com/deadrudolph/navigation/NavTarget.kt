package com.deadrudolph.navigation

open class NavTarget(val route: String)
sealed class GlobalNavTarget(
    val target: NavTarget,
) {
    data object HomeModule : GlobalNavTarget(target = NavTarget("home_module"))
    data object ProfileModule : GlobalNavTarget(target = NavTarget("profile_module"))
}
