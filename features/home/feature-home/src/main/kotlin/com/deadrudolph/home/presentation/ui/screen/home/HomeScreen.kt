package com.deadrudolph.home.presentation.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.deadrudolph.feature_home.R
import com.deadrudolph.home_domain.domain.model.response.User
import com.deadrudolph.uicomponents.utils.LoadState

@Composable
internal fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val userList = homeViewModel.usersFlow.collectAsState()

    userList.value.LoadState(
        onRestartState = homeViewModel::fetchContent,
        successContent = { data ->
            ScreenContent(
                usersList = data
            )
        }
    )
}

@Composable
private fun ScreenContent(usersList: List<User>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
        UsersList(
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp),
            usersList = usersList
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
        text = stringResource(id = R.string.fragment_home_title)
    )
}

@Composable
private fun UsersList(
    modifier: Modifier = Modifier,
    usersList: List<User>
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
                    userName = data.fullName,
                    address = data.address
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
    address: String
) {
    Column(
        modifier = Modifier
            .then(modifier)
    ) {
        Text(text = stringResource(id = R.string.user_name_template, userName))
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = stringResource(id = R.string.user_address_template, address)
        )
    }
}
