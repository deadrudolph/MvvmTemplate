package com.deadrudolph.home_domain.data.repository.users

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.commonnetwork.util.safeApiCall
import com.deadrudolph.home_domain.data.api.HomeApi
import com.deadrudolph.home_domain.data.mapper.UsersResponseToUsersMapper
import com.deadrudolph.home_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList
import javax.inject.Inject

internal class UsersRepositoryImpl @Inject constructor(
    private val api: HomeApi,
    private val usersResponseToUsersMapper: UsersResponseToUsersMapper,
) : UsersRepository {

    override suspend fun getUsers(pageNumber: Int): Result<ImmutableList<User>> = safeApiCall {
        Result.Success(usersResponseToUsersMapper(api.getUsers(pageNumber)))
    }
}
