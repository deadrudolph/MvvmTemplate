package com.deadrudolph.home_domain.data.api

import com.deadrudolph.home_domain.data.model.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface HomeApi {

    @GET(HomeNetworkConstants.USERS_PAGINATE)
    suspend fun getUsers(
        @Query("page") pageNumber: Int
    ): UsersResponse
}
