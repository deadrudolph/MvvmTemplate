package com.deadrudolph.profile_domain.data.api

import com.deadrudolph.profile_domain.data.model.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ProfileApi {

    @GET(ProfileNetworkConstants.USERS_PAGINATE)
    suspend fun getUsersPaginate(
        @Query("page") pageNumber: Int,
        @Query("limit") limit: Int,
    ): List<UserResponse>

    @GET(ProfileNetworkConstants.USER_DETAILS)
    suspend fun getUserDetails(
        @Path("userId") userId: String,
    ): UserResponse
}
