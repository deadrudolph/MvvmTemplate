package com.deadrudolph.template_mvvm.navigation.tab

import androidx.compose.ui.graphics.vector.ImageVector

internal data class TabItem(
    val label: Int,
    val icon: ImageVector,
    val route: String,
)
