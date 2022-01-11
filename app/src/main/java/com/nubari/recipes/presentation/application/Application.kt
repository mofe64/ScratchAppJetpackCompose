package com.nubari.recipes.presentation.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nubari.recipes.presentation.application.components.BottomNavigationBar
import com.nubari.recipes.presentation.application.components.MainAppBar
import com.nubari.recipes.presentation.components.NavigationHost

@ExperimentalPagerApi
@Composable
fun RecipeApplication() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
            )
        }
    ) {
        NavigationHost(navController = navController)
    }
}