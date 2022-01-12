package com.nubari.recipes.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nubari.recipes.presentation.feed.screens.FeedScreen
import com.nubari.recipes.presentation.profile.screens.Recipes
import com.nubari.recipes.presentation.profile.screens.ProfileScreen
import com.nubari.recipes.presentation.search.SearchScreen
import com.nubari.recipes.presentation.util.BaseScreen
import com.nubari.recipes.presentation.util.Screen

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
        navigation(
            startDestination = BaseScreen.Profile.route,
            route = BaseScreen.Profile.root
        ) {
            composable(BaseScreen.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(
                route = Screen.MyRecipesScreen.route + "?category={category}",
                arguments = listOf(
                    navArgument(
                        name = "category",
                    ) {
                        type = NavType.StringType
                        defaultValue = "main"
                    }
                )

            ) {
                val category = it.arguments?.getString("category") ?: "main"
                Recipes(navController = navController, category = category)
            }
        }
    }
}