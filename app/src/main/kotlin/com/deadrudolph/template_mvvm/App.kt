package com.deadrudolph.template_mvvm

import android.app.Application
import com.deadrudolph.commondi.component.app.ApplicationComponentDependenciesImpl
import com.deadrudolph.commondi.component.app.ApplicationComponentHolder
import com.deadrudolph.navigation.di.component.NavigationComponentHolder
import timber.log.Timber

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initGlobalNavigation()
        initTimber()
        initAppComponent()
    }

    private fun initGlobalNavigation() {
        NavigationComponentHolder.get()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initAppComponent() {
        ApplicationComponentHolder.init(
            ApplicationComponentDependenciesImpl(applicationContext)
        )
    }
}
