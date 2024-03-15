package com.deadrudolph.commondi.holder

import com.deadrudolph.commondi.component.base.BaseComponent

/**
 * Component holder, whose component needs to be manually passed to the method [set] and
 * cleared by calling [clear].
 */
abstract class SimpleComponentHolder<Component : BaseComponent> :
    BaseComponentHolder<Component> {

    private var component: Component? = null

    override fun get(): Component {
        return requireNotNull(component) { "${javaClass.simpleName} — component not found" }
    }

    override fun set(component: Component) {
        this.component = component
    }

    override fun clear() {
        this.component = null
    }
}
