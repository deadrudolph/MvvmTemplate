package com.deadrudolph.common_domain.state

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Throwable) : Result<Nothing>()
    data class Error(val code: Int, val message: String) : Result<Nothing>()
    data class Loading(val state: Boolean) : Result<Nothing>()
    data object IDLE : Result<Nothing>()
}
