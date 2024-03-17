package com.deadrudolph.profile.presentation.ui.screen.second

import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile_domain.domain.model.response.User
import com.deadrudolph.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SecondProfileViewModelImpl @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val navigator: Navigator,
) : SecondProfileViewModel() {

    override val userDataFlow: MutableStateFlow<Result<User>> =
        MutableStateFlow(Result.Loading(false))

    override fun fetchContent(id: String) {
        viewModelScope.launch {
            userDataFlow.value = Result.Loading(true)
            userDataFlow.value = getUserByIdUseCase(id)
        }
    }

    override fun onNextScreen() {
        navigator.navigateTo(GlobalNavTarget.HomeModule.target)
    }
}
