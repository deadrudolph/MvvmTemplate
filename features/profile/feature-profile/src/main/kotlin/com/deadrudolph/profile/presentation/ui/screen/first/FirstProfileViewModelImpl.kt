package com.deadrudolph.profile.presentation.ui.screen.first

import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.navigation.NavTarget
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile.navigation.ProfileNavTarget
import com.deadrudolph.profile_domain.domain.model.request.UserPageRequest
import com.deadrudolph.profile_domain.domain.model.response.User
import com.deadrudolph.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class FirstProfileViewModelImpl @Inject constructor(
    private val getUsersPageUseCase: GetUsersPageUseCase,
    private val navigator: Navigator,
) : FirstProfileViewModel() {

    override val usersFlow: MutableStateFlow<Result<List<User>>> =
        MutableStateFlow(Result.Loading(false))

    init {
        fetchContent()
    }

    override fun fetchContent() {
        viewModelScope.launch {
            usersFlow.value = Result.Loading(true)
            usersFlow.value = getUsersPageUseCase(
                UserPageRequest(
                    page = MOCK_PAGE
                )
            )
        }
    }

    override fun onClickNext(userId: String) {
        navigator.navigateTo(
            NavTarget.Builder()
                .addDestination(ProfileNavTarget.ProfileSecondFeature.route.route)
                .addArgument(userId)
                .build()
        )
    }

    private companion object {
        const val MOCK_PAGE = 1
    }
}
