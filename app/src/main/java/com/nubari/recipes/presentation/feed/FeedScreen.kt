package com.nubari.recipes.presentation.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.nubari.recipes.R
import com.nubari.recipes.domain.Meal
import com.nubari.recipes.presentation.application.components.MainAppBar
import com.nubari.recipes.presentation.components.NavigationBarAvoidingBox
import com.nubari.recipes.presentation.feed.components.FeedCard

@Composable
fun AppBarTitle() {
    Icon(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = "Home Logo",
        tint = MaterialTheme.colors.primary
    )
}


@Composable
fun FeedScreen(
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                navController = navController,
                title = {
                    AppBarTitle()
                }
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notifications),
                        contentDescription = "notifications"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_messages),
                        contentDescription = "messages"
                    )
                }
            }
        }
    ) {
        val x = listOf(
            Meal(
                "Vanilla Pud",
                R.drawable.feedimage2
            ),
            Meal(
                "White Wine Toffee",
                R.drawable.feedimage1
            ),
            Meal(
                "Vanilla Pud",
                R.drawable.feedimage2
            ),
            Meal(
                "White Wine Toffee",
                R.drawable.feedimage1
            ),

            )
        NavigationBarAvoidingBox() {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                items(x) { meal ->
                    FeedCard(name = meal.name, image = meal.image)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}