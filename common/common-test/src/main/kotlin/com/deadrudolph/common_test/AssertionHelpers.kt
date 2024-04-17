package com.deadrudolph.common_test

import app.cash.turbine.ReceiveTurbine
import app.cash.turbine.test
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat

/** actual mustBe expected */
infix fun Any?.mustBe(expected: Any?) {
    assertThat(this).isEqualTo(expected)
}

suspend fun <T> ReceiveTurbine<T>.nextItem() = awaitItem()

fun <T> Flow<T>.testFlow(block: suspend ReceiveTurbine<T>.() -> Unit) = runTest {
    this@testFlow.test {
        block(this)
    }
}

fun <T> Flow<T>.testFlowIt(block: suspend (ReceiveTurbine<T>) -> Unit) = runTest {
    this@testFlowIt.test {
        block(this)
    }
}

infix fun <T> ReceiveTurbine<T>.nextMustBe(actual: Any?) = runTest {
    nextItem() mustBe actual
}

inline var <reified T> ReceiveTurbine<T>.nextValue: Any?
    get() {
        throw IllegalAccessException("You cannot access this value")
    }
    set(value) {
        runTest {
            nextItem() mustBe value
        }
    }

/** actualList mustContain oneItem */
infix fun <T> List<T>?.mustContain(expected: T?) {
    assertThat(this).contains(expected)
}

/** actual mustBeIn expectedList */
infix fun Any?.mustBeIn(expected: List<Any?>) {
    assertThat(this).isIn(expected)
}

/** actual mustNotBe expected */
infix fun Any?.mustNotBe(expected: Any?) {
    assertThat(this).isNotEqualTo(expected)
}

/** actual mustRecursivelyBe "result" */
infix fun Any?.mustRecursivelyBe(expected: Any?) {
    assertThat(this).usingRecursiveComparison().isEqualTo(expected)
}

/** actualTrue mustBe true */
infix fun Boolean?.mustBe(expected: Boolean) {
    if (expected) {
        assertThat(this).isTrue
    } else {
        assertThat(this).isFalse
    }
}

/** actual mustBeInstanceOf ExpectedType::class.java */
inline infix fun <reified T> Any?.mustBeInstanceOf(expectedType: Class<T>) {
    assertThat(this).isInstanceOf(expectedType)
}

/** actual mustBeInstanceOf ExpectedType::class.java */
inline infix fun <reified T> Any?.mustNotBeInstanceOf(expectedType: Class<T>) {
    assertThat(this).isNotInstanceOf(expectedType)
}

/** listOf(actual1, actual2) mustBeEvery expected */
infix fun List<Any?>.mustBeEvery(expected: Any?) =
    forEach { item ->
        item mustBe expected
    }

/** listOf(actual1, actual2) mustNotBeAny expected */
infix fun List<Any?>.mustNotBeAny(expected: Any?) =
    forEach { item ->
        item mustNotBe expected
    }

/** listOf(actual1, actual2) mustRecursivelyBeEvery expected */
infix fun List<Any?>.mustRecursivelyBeEvery(expected: Any?) =
    forEach { item ->
        item mustRecursivelyBe expected
    }

/** listOf(actualTrue, actualTrue) mustBeEvery true */
infix fun List<Boolean?>.mustBeEvery(expected: Boolean) =
    forEach { item ->
        if (expected) {
            assertThat(item).isTrue
        } else {
            assertThat(item).isFalse
        }
    }

/** listOf(actual1, actual2) mustBeEveryInstanceOf ExpectedType::class.java */
inline infix fun <reified T> List<Any?>.mustBeEveryInstanceOf(expectedType: Class<T>) =
    forEach { item ->
        item mustBeInstanceOf expectedType
    }
