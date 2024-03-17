package com.deadrudolph.profile.presentation.ui.screen.second

import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.core.base.BaseViewModel
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.coroutines.flow.StateFlow

internal abstract class SecondProfileViewModel : BaseViewModel() {

    abstract val userDataFlow: StateFlow<Result<User>>

    abstract fun fetchContent(id: String)

    abstract fun onNextScreen()
}
