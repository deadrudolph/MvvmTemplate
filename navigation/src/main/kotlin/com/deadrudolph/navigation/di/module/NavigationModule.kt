package com.deadrudolph.navigation.di.module

import com.deadrudolph.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class NavigationModule {

    @Singleton
    @Provides
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}
