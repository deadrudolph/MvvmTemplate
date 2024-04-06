package com.deadrudolph.home.presentation.ui.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.deadrudolph.common_domain.state.Result
import com.deadrudolph.home_domain.domain.model.response.User
import com.deadrudolph.home_domain.domain.usecase.users.GetAllUsersUseCase
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeViewModelImpl @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
) : HomeViewModel() {

    override val usersFlow =
        MutableStateFlow<Result<ImmutableList<User>>>(Result.Loading(false))

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
            usersFlow.value = getAllUsersUseCase(MOCK_PAGE)
        }
    }

    private companion object {
        const val MOCK_PAGE = 1
    }
}
