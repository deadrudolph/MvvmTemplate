package com.deadrudolph.profile_domain.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class UsersResponse(
    val page: Long,
    @Json(name = "per_page")
    val perPage: Long,
    val total: Long,
    @Json(name = "total_pages")
    val totalPages: Long,
    val data: List<User>,
    val support: Support
)

@JsonClass(generateAdapter = true)
data class User(
    val id: Long,
    val email: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    val avatar: String,
)

@JsonClass(generateAdapter = true)
data class Support(
    val url: String,
    val text: String,
)
