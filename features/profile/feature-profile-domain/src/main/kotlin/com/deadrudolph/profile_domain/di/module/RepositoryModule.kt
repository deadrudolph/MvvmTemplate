package com.deadrudolph.profile_domain.di.module

import com.deadrudolph.profile_domain.data.repository.UsersRepository
import com.deadrudolph.profile_domain.data.repository.UsersRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindHomeRepository(impl: UsersRepositoryImpl): UsersRepository
}
