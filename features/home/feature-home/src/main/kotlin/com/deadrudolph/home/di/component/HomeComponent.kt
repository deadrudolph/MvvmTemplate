package com.deadrudolph.home.di.component

import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.FeatureComponentHolder
import com.deadrudolph.commondi.module.CommonDiModule
import com.deadrudolph.commondi.util.DaggerViewModelProvider
import com.deadrudolph.home.di.dependencies.DependenciesImpl
import com.deadrudolph.home.di.module.ViewModelModule
import com.deadrudolph.home_domain.domain.usecase.users.GetAllUsersUseCase
import com.deadrudolph.navigation.Navigator
import dagger.Component

interface HomeComponent : BaseComponent, DaggerViewModelProvider

@Component(
    modules = [
        CommonDiModule::class,
        ViewModelModule::class
    ],

    dependencies = [
        HomeComponentInternal.Dependencies::class,
    ]
)
internal interface HomeComponentInternal :
    HomeComponent {

    interface Dependencies {
        val navigation: Navigator
        val getAllUsersUseCase: GetAllUsersUseCase
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): HomeComponentInternal
    }
}

object HomeComponentHolder : FeatureComponentHolder<HomeComponent>() {

    override fun build(): HomeComponent {
        return DaggerHomeComponentInternal.factory().create(
            DependenciesImpl(),
        )
    }

    internal fun getInternal(): HomeComponentInternal = get() as HomeComponentInternal
}
