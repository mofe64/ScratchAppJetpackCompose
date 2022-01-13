package com.nubari.recipes.presentation.application.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.TopAppBar
import com.nubari.recipes.R
import com.nubari.recipes.ui.theme.SubTextColor

@Composable
fun MainAppBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    backgroundColor: Color = Color.White,
    backTextColor: Color = SubTextColor,
    backIconColor: Color = Color.White,
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},

) {
    TopAppBar(
        modifier = modifier,
        title = {
            title()
        },
        navigationIcon = if (
            navController.previousBackStackEntry != null &&
            navController.previousBackStackEntry?.destination?.route.toString() != "feed"
        ) {
            {
                var previousScreen = ""
                previousScreen = navController.previousBackStackEntry?.destination?.route.toString()
                IconButton(onClick = { navController.navigateUp() }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back button",
                            tint = backIconColor
                        )
                        Spacer(modifier = Modifier.width(15.dp))
//                        Text(
//                            text = if (previousScreen !== "") "Back to $previousScreen" else "Back"
//                        )
                        Text(text = "Back", color = backTextColor)
                    }
                }
            }
        } else {
            null
        },

        actions = {
            actions()
        },
        backgroundColor = backgroundColor,
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