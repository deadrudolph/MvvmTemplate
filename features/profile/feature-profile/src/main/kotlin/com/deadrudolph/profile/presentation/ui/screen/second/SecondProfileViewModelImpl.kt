package com.deadrudolph.profile.presentation.ui.screen.second

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.profile_domain.domain.model.response.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SecondProfileViewModelImpl @Inject constructor(
    // private val getUserByIdUseCase: GetUserByIdUseCase,
    private val navigator: Navigator,
) : SecondProfileViewModel() {

    override val userDataFlow: MutableStateFlow<Result<User>> =
        MutableStateFlow(Result.Loading(false))

    init {
        Log.d("LifecycleTest", "Init SecodProfileViewModel")
        fetchContent()
    }

    override fun onCleared() {
        Log.d("LifecycleTest", "onCleared SecondProfileViewModel")
        super.onCleared()
    }

    override fun fetchContent(id: String) {
        viewModelScope.launch {
            userDataFlow.value = Result.Loading(true)
            // userDataFlow.value = getUserByIdUseCase(id)

            // TODO Mock data
            userDataFlow.value = Result.Success(
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
        }
    }

    override fun onNextScreen() {
        navigator.navigateTo(GlobalNavTarget.HomeModule.target)
    }
}
