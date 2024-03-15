package com.deadrudolph.home_domain.domain.usecase.users

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User

interface GetAllUsersUseCase {

    suspend operator fun invoke(): Result<List<User>>
}
