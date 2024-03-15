package com.deadrudolph.commondi.component.app

import android.content.Context
import com.deadrudolph.commondi.component.base.BaseComponent
import dagger.Component

/**
 * This component is intended to keep **system** dependencies that can be obtained only in the
 * `app` module.
 */
interface ApplicationComponent : BaseComponent {

    fun applicationContext(): Context
}

@Component(
    dependencies = [
        ApplicationComponentDependencies::class,
    ]
)
internal interface ApplicationComponentInternal : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ApplicationComponentDependencies,
        ): ApplicationComponent
    }
}
