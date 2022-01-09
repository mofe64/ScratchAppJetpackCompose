package com.nubari.recipes.presentation.application

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ui.Scaffold
import com.nubari.recipes.presentation.application.components.BottomNavigationBar
import com.nubari.recipes.presentation.components.NavigationHost

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