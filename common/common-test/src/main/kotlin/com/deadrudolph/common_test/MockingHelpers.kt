package com.deadrudolph.common_test

import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.whenever

/** mock.doAction() gives "action result" */
infix fun Any?.gives(result: Any?) = whenever(this).doReturn(result)

/** mock.doAction() throws Exception() */
infix fun Any?.throws(exception: Exception) = whenever(this).doThrow(exception)

/** val spy = functionSpy<(Argument) -> Result>() */
inline fun <reified T : kotlin.Function<*>> functionSpy(): T {
    return Mockito.spy(T::class.java)
}
