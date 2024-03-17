package com.deadrudolph.profile.presentation.ui.screen.first

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.core.base.BaseViewModel
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.coroutines.flow.StateFlow

internal abstract class FirstProfileViewModel : BaseViewModel() {

    abstract val usersFlow: StateFlow<Result<List<User>>>

    abstract fun fetchContent()
    abstract fun onClickNext(userId: String)
}
