package com.deadrudolph.profile_domain.di.module

import com.deadrudolph.profile_domain.data.api.ProfileApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
internal class NetworkModule {

    @Reusable
    @Provides
    fun provideHomeApi(retrofit: Retrofit): ProfileApi {
        return retrofit.create(ProfileApi::class.java)
    }
}
