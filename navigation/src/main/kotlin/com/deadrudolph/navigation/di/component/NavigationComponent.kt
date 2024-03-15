package com.deadrudolph.navigation.di.component

import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.ComponentHolder
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.navigation.di.module.NavigationModule
import dagger.Component
import javax.inject.Singleton

interface NavigationComponent : BaseComponent {
    fun navigator(): Navigator
}

@Singleton
@Component(
    modules = [
        NavigationModule::class,
    ],
)
internal interface NavigationComponentInternal : NavigationComponent {

    @Component.Factory
    interface Factory {
        fun create(): NavigationComponentInternal
    }
}

object NavigationComponentHolder : ComponentHolder<NavigationComponent>() {

    override fun build(): NavigationComponent {
        return DaggerNavigationComponentInternal.factory().create()
    }

    internal fun getInternal(): NavigationComponentInternal = get() as NavigationComponentInternal
}
