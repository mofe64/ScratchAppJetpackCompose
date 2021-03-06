package com.nubari.recipes.presentation.feed.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nubari.recipes.R
import com.nubari.recipes.presentation.application.components.MainAppBar
import com.nubari.recipes.presentation.components.NavigationBarAvoidingBox
import com.nubari.recipes.presentation.feed.components.FeedCard
import com.nubari.recipes.presentation.feed.viewModels.FeedViewModel

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
    feedViewModel: FeedViewModel = viewModel()
) {
    val state = feedViewModel.state.value
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
        NavigationBarAvoidingBox() {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                items(state.recipes) { meal ->
                    FeedCard(name = meal.name, image = meal.image, cookBooks = state.cookBooks)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}