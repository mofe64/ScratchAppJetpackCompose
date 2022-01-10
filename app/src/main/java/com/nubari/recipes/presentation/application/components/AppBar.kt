package com.nubari.recipes.presentation.application.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.TopAppBar
import com.nubari.recipes.R

@Composable
fun MainAppBar(
    navController: NavController,
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = {
            title()
        },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back button"
                        )
                        Text(text = "back")
                    }
                }
            }
        } else {
            null
        },

        actions = {
            actions()
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 0.dp,
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.statusBars,
            applyStart = true,
            applyTop = true,
            applyEnd = true
        )
    )
}