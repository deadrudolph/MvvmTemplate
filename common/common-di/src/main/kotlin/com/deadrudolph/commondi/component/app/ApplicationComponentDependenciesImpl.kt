package com.deadrudolph.commondi.component.app

import android.content.Context

data class ApplicationComponentDependenciesImpl(
    override val context: Context
) : ApplicationComponentDependencies
