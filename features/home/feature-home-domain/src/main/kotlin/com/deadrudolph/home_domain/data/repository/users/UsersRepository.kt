package com.deadrudolph.home_domain.data.repository.users

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList

internal interface UsersRepository {

    suspend fun getUsers(pageNumber: Int): Result<ImmutableList<User>>
}
