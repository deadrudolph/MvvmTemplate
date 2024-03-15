package com.deadrudolph.profile.navigation

import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.NavTarget

internal sealed class ProfileNavTarget(
    val route: NavTarget
) {
    data object ProfileFirstFeature : ProfileNavTarget(route = NavTarget("profile_first_feature"))
    data object ProfileSecondFeature : ProfileNavTarget(route = NavTarget("profile_second_feature"))

    companion object {

        val moduleRoute: NavTarget = GlobalNavTarget.ProfileModule.target
    }
}
