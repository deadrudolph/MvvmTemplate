package com.deadrudolph.commondi.holder

import com.deadrudolph.commondi.component.base.BaseComponent

/**
 * Default component holder.
 *
 * This holder automatically creates component instance when call [get] if component is not created
 * at that moment.
 * Component also still can be set manually by calling [set].
 *
 * In general it's intended for cases if you don't want to call [set] manually.
 * However [clear] still should be called when needed to avoid memory leaks.
 */
abstract class ComponentHolder<Component : BaseComponent> :
    BaseComponentHolder<Component> {

    private var component: Component? = null

    override fun get(): Component {
        return component ?: build().also {
            set(it)
        }
    }

    override fun set(component: Component) {
        this.component = component
    }

    /**
     * Creates component instance.
     */
    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
