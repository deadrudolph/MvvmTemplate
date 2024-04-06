package com.deadrudolph.home.presentation.ui.screen.home

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.core.base.BaseViewModel
import com.deadrudolph.home_domain.domain.model.response.User
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.StateFlow

internal abstract class HomeViewModel : BaseViewModel() {

    abstract val usersFlow: StateFlow<Result<ImmutableList<User>>>

    abstract fun fetchContent()
}
