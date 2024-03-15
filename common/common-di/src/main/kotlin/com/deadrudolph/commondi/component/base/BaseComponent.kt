package com.deadrudolph.commondi.component.base

/**
 * Marker interface for objects that can be stored into [BaseComponentHolder].
 *
 * Any object can implement [BaseComponent]; usually components contain data that we want to share.
 * It's usually used by modules to define their API or dependencies.
 */
interface BaseComponent
