package com.nubari.recipes.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets

@Composable
fun NavigationBarAvoidingBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val insets = LocalWindowInsets.current
    val systemNavBarBottom = with(LocalDensity.current) {
        insets.navigationBars.bottom.toDp()
    }
    val appNavBarHeight = 56.dp
    val paddingRequired = systemNavBarBottom + appNavBarHeight
    Box(
        modifier = modifier.padding(
            bottom = paddingRequired
        )
    ) {
        content()
    }
}