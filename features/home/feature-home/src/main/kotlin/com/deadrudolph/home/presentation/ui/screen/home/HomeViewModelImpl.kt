package com.deadrudolph.home.presentation.ui.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeViewModelImpl @Inject constructor(
    // private val getAllUsersUseCase: GetAllUsersUseCase,
) : HomeViewModel() {

    override val usersFlow =
        MutableStateFlow<Result<List<User>>>(Result.Loading(false))

    init {
        Log.d("LifecycleTest", "Init Home ViewModel")
        fetchContent()
    }

    override fun onCleared() {
        Log.d("LifecycleTest", "onCleared Home ViewModel")
        super.onCleared()
    }

    override fun fetchContent() {
        viewModelScope.launch {
            usersFlow.value = Result.Loading(true)
            // usersFlow.value = getAllUsersUseCase()

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
}
