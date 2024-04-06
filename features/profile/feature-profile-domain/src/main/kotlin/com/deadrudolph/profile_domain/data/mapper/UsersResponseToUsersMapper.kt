package com.deadrudolph.profile_domain.data.mapper

import com.deadrudolph.profile_domain.data.model.response.UsersResponse
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

internal class UsersResponseToUsersMapper @Inject constructor() :
    (UsersResponse) -> ImmutableList<User> {

    override operator fun invoke(usersResponse: UsersResponse) =
        usersResponse.data.map { user ->
            User(
                id = user.id,
                firstName = user.firstName,
                lastName = user.lastName,
                avatar = user.avatar,
                email = user.email,
            )
        }.toImmutableList()
}
