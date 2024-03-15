package com.deadrudolph.profile_domain.domain.usecase.userspage

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.profile_domain.domain.model.request.UserPageRequest
import com.deadrudolph.profile_domain.domain.model.response.User

interface GetUsersPageUseCase {

    suspend operator fun invoke(userPageRequest: UserPageRequest): Result<List<User>>
}
