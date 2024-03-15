package com.deadrudolph.profile_domain.di.module

import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCaseImpl
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCaseModule {

    @Binds
    fun getUsersPageUseCase(impl: GetUsersPageUseCaseImpl): GetUsersPageUseCase

    @Binds
    fun getUserByIdUseCase(impl: GetUserByIdUseCaseImpl): GetUserByIdUseCase
}
