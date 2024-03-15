package com.deadrudolph.profile_domain.di.component

import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.FeatureComponentHolder
import com.deadrudolph.profile_domain.di.dependencies.DependenciesImpl
import com.deadrudolph.profile_domain.di.module.NetworkModule
import com.deadrudolph.profile_domain.di.module.RepositoryModule
import com.deadrudolph.profile_domain.di.module.UseCaseModule
import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import dagger.Component
import retrofit2.Retrofit

interface ProfileDomainComponent : BaseComponent {

    fun getUsersPageUseCase(): GetUsersPageUseCase

    fun getUserByIdUseCase(): GetUserByIdUseCase
}

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ],

    dependencies = [
        ProfileDomainComponentInternal.Dependencies::class,
    ]
)
internal interface ProfileDomainComponentInternal : ProfileDomainComponent {

    interface Dependencies {
        val retrofit: Retrofit
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): ProfileDomainComponentInternal
    }
}

object ProfileDomainComponentHolder : FeatureComponentHolder<ProfileDomainComponent>() {

    override fun build(): ProfileDomainComponent {
        return DaggerProfileDomainComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): ProfileDomainComponentInternal =
        get() as ProfileDomainComponentInternal
}
