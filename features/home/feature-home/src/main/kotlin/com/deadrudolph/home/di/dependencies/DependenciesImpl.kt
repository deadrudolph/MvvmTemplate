package com.deadrudolph.home.di.dependencies

import com.deadrudolph.home.di.component.HomeComponentInternal
import com.deadrudolph.home_domain.di.component.HomeDomainComponentHolder
import com.deadrudolph.home_domain.domain.usecase.users.GetAllUsersUseCase
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.navigation.di.component.NavigationComponentHolder

internal class DependenciesImpl : HomeComponentInternal.Dependencies {

    override val navigation: Navigator
        get() = NavigationComponentHolder.get().navigator()
    override val getAllUsersUseCase: GetAllUsersUseCase
        get() = HomeDomainComponentHolder.get().getAllUsersUseCase()
}
