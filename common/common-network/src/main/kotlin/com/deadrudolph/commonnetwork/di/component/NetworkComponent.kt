package com.deadrudolph.commonnetwork.di.component

import android.content.Context
import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.ComponentHolder
import com.deadrudolph.commonnetwork.di.dependencies.DependenciesImpl
import com.deadrudolph.commonnetwork.di.module.ConfigModule
import com.deadrudolph.commonnetwork.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

interface NetworkComponent : BaseComponent {

    fun networkClient(): Retrofit
}

@Singleton
@Component(
    modules = [
        ConfigModule::class,
        NetworkModule::class,
    ],
    dependencies = [NetworkComponentInternal.Dependencies::class]
)
internal interface NetworkComponentInternal : NetworkComponent {

    interface Dependencies {
        val context: Context
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): NetworkComponentInternal
    }
}

object NetworkComponentHolder : ComponentHolder<NetworkComponent>() {

    override fun build(): NetworkComponent {
        return DaggerNetworkComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): NetworkComponentInternal = get() as NetworkComponentInternal
}
