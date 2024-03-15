package com.deadrudolph.template_mvvm.di.component.main

import com.deadrudolph.commondi.component.base.BaseComponent
import com.deadrudolph.commondi.holder.FeatureComponentHolder
import dagger.Component

interface AppComponent : BaseComponent

@Component()
internal interface AppComponentInternal :
    AppComponent,
    AppActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponentInternal
    }
}

object AppComponentHolder : FeatureComponentHolder<AppComponent>() {

    override fun build(): AppComponent {
        return DaggerAppComponentInternal.factory().create()
    }

    internal fun getInternal(): AppComponentInternal = get() as AppComponentInternal
}
