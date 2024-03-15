package com.deadrudolph.profile.presentation.ui.screen.first

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile.navigation.ProfileNavTarget
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class FirstProfileViewModelImpl @Inject constructor(
    // private val getUsersPageUseCase: GetUsersPageUseCase,
    private val navigator: Navigator,
) : FirstProfileViewModel() {

    override val usersFlow: MutableStateFlow<Result<List<User>>> =
        MutableStateFlow(Result.Loading(false))

    init {
        Log.d("LifecycleTest", "Init FirstProfileViewModel")
        fetchContent()
    }

    override fun onCleared() {
        Log.d("LifecycleTest", "onCleared FirstProfileViewModel")
        super.onCleared()
    }

    override fun fetchContent() {
        viewModelScope.launch {
            usersFlow.value = Result.Loading(true)
            /*usersFlow.value = getUsersPageUseCase(
                UserPageRequest(
                    page = MOCK_PAGE,
                    limit = MOCK_LIMIT
                )
            )*/
            // TODO Mock data
            usersFlow.value = Result.Success(
                listOf(
                    User(
                        id = "MockData",
                        fullName = "MockData",
                        firstName = "MockData",
                        lastName = "MockData",
                        gender = "MockData",
                        birthday = "MockData",
                        age = 5,
                        avatar = "MockData",
                        address = "MockData",
                        zip = "MockData",
                        state = "MockData",
                        phone = "MockData",
                        email = "MockData",
                        twitter = "MockData",
                        ssn = "MockData",
                    )
                )
            )
        }
    }

    override fun onClickNext() {
        navigator.navigateTo(ProfileNavTarget.ProfileSecondFeature.route)
    }

    private companion object {
        const val MOCK_PAGE = 1
        const val MOCK_LIMIT = 10
    }
}
