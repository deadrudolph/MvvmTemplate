package com.deadrudolph.home_domain.data.repository.users

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User

internal interface UsersRepository {

    suspend fun getUsers(pageNumber: Int): Result<List<User>>
}
