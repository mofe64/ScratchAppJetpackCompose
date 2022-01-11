package com.nubari.recipes.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nubari.recipes.presentation.feed.screens.FeedScreen
import com.nubari.recipes.presentation.profile.screens.ProfileScreen
import com.nubari.recipes.presentation.search.SearchScreen
import com.nubari.recipes.presentation.util.BaseScreen

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BaseScreen.Feed.route) {
        composable(BaseScreen.Feed.route) {
            FeedScreen(navController = navController)
        }
        composable(BaseScreen.Search.route) {
            SearchScreen()
        }
        composable(BaseScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}