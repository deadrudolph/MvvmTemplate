package com.deadrudolph.uicomponents.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.deadrudolph.uicomponents.compose.theme.CustomTheme

@Composable
fun DefaultErrorDialog(
    text: String,
    onDismissed: () -> Unit
) {
    Dialog(
        onDismissRequest = {
            onDismissed()
        }
    ) {
        Text(
            modifier = Modifier
                .background(color = Color.Red, shape = RoundedCornerShape(18.dp))
                .padding(15.dp),
            text = text,
            style = CustomTheme.typography.body3.copy(color = Color.Black)
        )
    }
}
