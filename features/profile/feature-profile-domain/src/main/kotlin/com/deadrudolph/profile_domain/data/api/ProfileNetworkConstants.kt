package com.deadrudolph.profile_domain.data.api

internal object ProfileNetworkConstants {

    private const val USERS = "users"

    // USERS PAGINATE
    const val USERS_PAGINATE = USERS

    // SINGLE USER
    const val SINGLE_USER = "$USERS/{userId}"

    // GRAPHQL
    const val GRAPHQL_USER = "/graphql"
}
