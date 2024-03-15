package com.deadrudolph.profile.di.component

import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.FeatureComponentHolder
import com.deadrudolph.commondi.module.CommonDiModule
import com.deadrudolph.commondi.util.DaggerViewModelProvider
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile.di.dependencies.DependenciesImpl
import com.deadrudolph.profile.di.module.ViewModelModule
import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import dagger.Component

interface ProfileComponent : BaseComponent, DaggerViewModelProvider

@Component(
    modules = [
        CommonDiModule::class,
        ViewModelModule::class,
    ],
    dependencies = [
        ProfileComponentInternal.Dependencies::class,
    ]
)
internal interface ProfileComponentInternal :
    ProfileComponent {

    interface Dependencies {
        val navigator: Navigator
        val getUserByIdUseCase: GetUserByIdUseCase
        val getUsersPageUseCase: GetUsersPageUseCase
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): ProfileComponentInternal
    }
}

object ProfileComponentHolder : FeatureComponentHolder<ProfileComponent>() {

    override fun build(): ProfileComponent {
        return DaggerProfileComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): ProfileComponentInternal = get() as ProfileComponentInternal
}
