package com.deadrudolph.uicomponents.compose.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DefaultLoading() {
    Dialog(
        onDismissRequest = { }
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp, 100.dp)
        )
    }
}
