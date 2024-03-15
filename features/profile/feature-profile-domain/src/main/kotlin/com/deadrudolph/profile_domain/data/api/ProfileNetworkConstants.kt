package com.deadrudolph.profile_domain.data.api

internal object ProfileNetworkConstants {

    private const val USER_ID = "userId"

    private const val USERS = "users"

    // USERS PAGINATE
    const val USERS_PAGINATE = "/$USERS/paginate"

    // USERS DETAILS
    const val USER_DETAILS = "/$USERS/details/{$USER_ID}"

    // GRAPHQL
    const val GRAPHQL_USER = "/graphql"
}
