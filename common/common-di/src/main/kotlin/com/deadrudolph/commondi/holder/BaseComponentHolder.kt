package com.deadrudolph.commondi.holder

import com.deadrudolph.commondi.component.base.BaseComponent

/**
 * Base interface for storing and providing [BaseComponent]
 */
interface BaseComponentHolder<Component : BaseComponent> {

    fun get(): Component

    fun set(component: Component)

    fun clear()
}
