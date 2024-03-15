package com.deadrudolph.commondi.holder

import android.util.Log
import com.deadrudolph.commondi.component.base.BaseComponent

/**
 * Behaves like [SimpleComponentHolder], but additional [Data] can be passed via method [init]
 */
abstract class DataComponentHolder<Component : BaseComponent, Data : Any> :
    BaseComponentHolder<Component> {

    private val tag = this::class.java.simpleName

    private var component: Component? = null

    override fun get(): Component {
        return requireNotNull(component) { "${javaClass.simpleName} — component not found" }
    }

    public fun init(data: Data) {
        component ?: build(data).also { component = it }
    }

    override fun set(component: Component) {
        this.component = component
    }

    override fun clear() {
        Log.i(tag, "Component $component was cleared")
        component = null
    }

    protected abstract fun build(data: Data): Component
}
