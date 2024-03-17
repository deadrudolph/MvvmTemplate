package com.deadrudolph.profile_domain.domain.model.response

data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
)
