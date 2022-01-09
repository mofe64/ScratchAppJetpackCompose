package com.nubari.recipes.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nubari.recipes.presentation.feed.FeedScreen
import com.nubari.recipes.presentation.profile.ProfileScreen
import com.nubari.recipes.presentation.search.SearchScreen
import com.nubari.recipes.presentation.util.BaseScreen

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BaseScreen.Feed.route) {
        composable(BaseScreen.Feed.route) {
            FeedScreen()
        }
        composable(BaseScreen.Search.route) {
            SearchScreen()
        }
        composable(BaseScreen.Profile.route) {
            ProfileScreen()
        }
    }
}