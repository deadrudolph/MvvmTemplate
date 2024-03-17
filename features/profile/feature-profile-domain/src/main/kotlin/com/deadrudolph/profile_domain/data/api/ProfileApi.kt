package com.deadrudolph.profile_domain.data.api

import com.deadrudolph.profile_domain.data.model.response.SingleUserResponse
import com.deadrudolph.profile_domain.data.model.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ProfileApi {

    @GET(ProfileNetworkConstants.USERS_PAGINATE)
    suspend fun getUsersPaginate(
        @Query("page") pageNumber: Int
    ): UsersResponse

    @GET(ProfileNetworkConstants.SINGLE_USER)
    suspend fun getUserDetails(
        @Path("userId") userId: String,
    ): SingleUserResponse
}
