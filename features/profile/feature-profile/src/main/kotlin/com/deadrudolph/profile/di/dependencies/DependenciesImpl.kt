package com.deadrudolph.profile.di.dependencies

import com.deadrudolph.navigation.Navigator
import com.deadrudolph.navigation.di.component.NavigationComponentHolder
import com.deadrudolph.profile.di.component.ProfileComponentInternal
import com.deadrudolph.profile_domain.di.component.ProfileDomainComponentHolder
import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCase

internal class DependenciesImpl : ProfileComponentInternal.Dependencies {

    override val navigator: Navigator
        get() = NavigationComponentHolder.get().navigator()

    override val getUserByIdUseCase: GetUserByIdUseCase
        get() = ProfileDomainComponentHolder.get().getUserByIdUseCase()

    override val getUsersPageUseCase: GetUsersPageUseCase
        get() = ProfileDomainComponentHolder.get().getUsersPageUseCase()
}
