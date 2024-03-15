package com.deadrudolph.profile_domain.di.dependencies

import com.deadrudolph.commonnetwork.di.component.NetworkComponentHolder
import com.deadrudolph.profile_domain.di.component.ProfileDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : ProfileDomainComponentInternal.Dependencies {

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}
