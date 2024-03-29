package com.deadrudolph.profile.presentation.ui.screen.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.deadrudolph.feature_profile.R
import com.deadrudolph.profile_domain.domain.model.response.User
import com.deadrudolph.uicomponents.compose.components.DefaultErrorDialog
import com.deadrudolph.uicomponents.compose.components.DefaultLoading
import com.deadrudolph.uicomponents.utils.LoadState

@Composable
internal fun SecondProfileScreen(
    viewModel: SecondProfileViewModel,
    userId: String,
    popBackStack: () -> Unit,
) {
    val userList = viewModel.userDataFlow.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchContent(userId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        userList.value.LoadState(
            onRestartState = { viewModel.fetchContent(userId) },
            successContent = { data ->
                ScreenContent(
                    user = data,
                    onClickPrev = {
                        popBackStack()
                    },
                    onClickNext = viewModel::onNextScreen
                )
            },
            loadingView = { isLoading ->
                if (isLoading) DefaultLoading()
            },
            errorView = { message ->
                DefaultErrorDialog(text = message) {
                    viewModel.fetchContent(userId)
                }
            }
        )
    }
}

@Composable
private fun ScreenContent(
    user: User,
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit,
) {
    val resultList = listOf(
        stringResource(R.string.user_name_template, user.firstName),
        stringResource(R.string.user_address_template, user.email),
        stringResource(R.string.user_id_template, user.id),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Header()
        InfoList(
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp),
            usersList = resultList
        )
        ActionButtons(
            modifier = Modifier
                .padding(top = 20.dp),
            onClickPrev = onClickPrev,
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
        text = stringResource(id = R.string.fragment_profile_second_title)
    )
}

@Composable
private fun InfoList(
    modifier: Modifier = Modifier,
    usersList: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .then(modifier),
        content = {
            items(
                items = usersList
            ) { data ->
                InfoItem(text = data)
            }
        },
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
}

@Composable
private fun InfoItem(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = Modifier
            .then(modifier),
        text = text
    )
}

@Composable
private fun ActionButtons(
    modifier: Modifier = Modifier,
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit,
) {
    Row(
        modifier = Modifier
            .then(modifier)
    ) {
        Button(
            modifier = Modifier
                .weight(1f),
            onClick = onClickPrev
        ) {
            Text(text = stringResource(id = R.string.back_to_profile_first_fragment))
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(start = 25.dp),
            onClick = onClickNext
        ) {
            Text(text = stringResource(id = R.string.go_to_profile_third_fragment))
        }
    }
}
