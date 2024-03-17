package com.deadrudolph.profile.presentation.ui.screen.first

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.deadrudolph.feature_profile.R
import com.deadrudolph.profile_domain.domain.model.response.User
import com.deadrudolph.uicomponents.compose.components.DefaultErrorDialog
import com.deadrudolph.uicomponents.compose.components.DefaultLoading
import com.deadrudolph.uicomponents.utils.LoadState

@Composable
internal fun FirstProfileScreen(
    viewModel: FirstProfileViewModel
) {
    val userList = viewModel.usersFlow.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchContent()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        userList.value.LoadState(
            onRestartState = viewModel::fetchContent,
            successContent = { data ->
                ScreenContent(
                    usersList = data,
                    onClickNext = viewModel::onClickNext
                )
            },
            loadingView = { isLoading ->
                if (isLoading) DefaultLoading()
            },
            errorView = { message ->
                DefaultErrorDialog(text = message) {
                    viewModel.fetchContent()
                }
            }
        )
    }
}

@Composable
private fun ScreenContent(
    usersList: List<User>,
    onClickNext: (userId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
        UsersList(
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp),
            usersList = usersList,
            onClickNext = onClickNext
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = Modifier
            .then(modifier),
        text = stringResource(id = R.string.fragment_profile_title)
    )
}

@Composable
private fun UsersList(
    modifier: Modifier = Modifier,
    usersList: List<User>,
    onClickNext: (userId: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .then(modifier),
        content = {
            items(
                items = usersList,
                key = { item -> item.id }
            ) { data ->
                UserItem(
                    userName = data.firstName,
                    address = data.email,
                    userId = data.id.toString(),
                    onClickNext = onClickNext
                )
            }
        },
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
}

@Composable
private fun UserItem(
    modifier: Modifier = Modifier,
    userName: String,
    address: String,
    userId: String,
    onClickNext: (userId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClickNext(userId) }
            .then(modifier),
    ) {
        Text(text = stringResource(id = R.string.user_name_template, userName))
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = stringResource(id = R.string.user_address_template, address)
        )
    }
}
