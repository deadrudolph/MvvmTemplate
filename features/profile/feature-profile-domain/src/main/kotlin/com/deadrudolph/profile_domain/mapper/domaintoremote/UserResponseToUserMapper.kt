package com.deadrudolph.profile_domain.mapper.domaintoremote

import com.deadrudolph.profile_domain.data.model.response.SingleUserResponse
import com.deadrudolph.profile_domain.domain.model.response.User
import javax.inject.Inject

internal class UserResponseToUserMapper @Inject constructor() :
    (SingleUserResponse) -> User {

    override fun invoke(user: SingleUserResponse) = User(
        id = user.data.id,
        firstName = user.data.firstName,
        lastName = user.data.lastName,
        avatar = user.data.avatar,
        email = user.data.email,
    )
}
