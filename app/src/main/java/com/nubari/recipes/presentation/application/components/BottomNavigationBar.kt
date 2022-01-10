package com.nubari.recipes.presentation.application.components

import android.util.Log
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.nubari.recipes.presentation.util.BaseScreen
import com.nubari.recipes.presentation.util.navScreens

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    screens: List<BaseScreen> = navScreens,
    navController: NavController
) {
    //using accompanist Bottom Naw which supports end to end display
    com.google.accompanist.insets.ui.BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.navigationBars,
            applyStart = true,
            applyTop = true,
            applyEnd = true
        ),
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        screens.forEach { screen ->
            BottomNavigationItem(
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = Color(0xFF363837),
                selected = currentRoute?.hierarchy?.any {
                    screen.route == it.route
                } == true,
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.name
                    )
                },
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}