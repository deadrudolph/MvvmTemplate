package com.deadrudolph.commondi.holder

import com.deadrudolph.commondi.component.base.BaseComponent
import java.lang.ref.WeakReference

/**
 *
 * Component holder with automatic cleaning.
 * Behaves same as [BaseComponentHolder], but holds component as a weak reference,
 * which means that reference will be cleaned in closest GC cycle if no one else holds reference to
 * component received by [get].
 *
 * It means that no need to call [set] and [clear] manually. Component builds during
 * first [get] call and cleared when there are not links to it is left.
 *
 * Can be useful to implement "feature scope": when user navigates outside of feature, the component
 * and all it's data most likely will be collected by GC.
 */
abstract class FeatureComponentHolder<Component : BaseComponent> :
    BaseComponentHolder<Component> {

    private var component: WeakReference<Component>? = null

    override fun get(): Component {
        return component?.get() ?: build().also {
            set(it)
        }
    }

    /**
     * Create weak reference to component
     *
     * Note: The method doesn't create strong reference.
     * You must keep a reference to the component in client code
     * The method must be using only in tests for substitution on testing subjects
     *
     * @param component DI component
     */
    override fun set(component: Component) {
        this.component = WeakReference(component)
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
