package com.deadrudolph.profile_domain.data.repository

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.profile_domain.domain.model.request.UserPageRequest
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList

internal interface UsersRepository {

    suspend fun getPageOfUsersList(userPageRequest: UserPageRequest): Result<ImmutableList<User>>

    suspend fun getUserById(userId: String): Result<User>
}
