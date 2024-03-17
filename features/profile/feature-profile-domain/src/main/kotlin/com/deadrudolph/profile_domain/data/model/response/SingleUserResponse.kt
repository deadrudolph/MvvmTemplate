package com.deadrudolph.profile_domain.data.model.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SingleUserResponse(
    val data: User,
    val support: Support
)
