package com.deadrudolph.profile_domain.domain.usecase.getuser

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.profile_domain.data.repository.UsersRepository
import com.deadrudolph.profile_domain.domain.model.response.User
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
) : GetUserByIdUseCase {

    override suspend fun invoke(userId: String): Result<User> =
        usersRepository.getUserById(userId)
}
