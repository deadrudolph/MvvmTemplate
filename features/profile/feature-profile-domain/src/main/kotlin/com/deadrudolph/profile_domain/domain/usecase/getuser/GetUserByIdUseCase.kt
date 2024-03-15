package com.deadrudolph.profile_domain.domain.usecase.getuser

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.profile_domain.domain.model.response.User

interface GetUserByIdUseCase {

    suspend operator fun invoke(userId: String): Result<User>
}
