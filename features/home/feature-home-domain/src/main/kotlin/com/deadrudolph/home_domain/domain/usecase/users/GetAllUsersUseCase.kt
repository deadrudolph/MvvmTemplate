package com.deadrudolph.home_domain.domain.usecase.users

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList

interface GetAllUsersUseCase {

    suspend operator fun invoke(pageNumber: Int): Result<ImmutableList<User>>
}
