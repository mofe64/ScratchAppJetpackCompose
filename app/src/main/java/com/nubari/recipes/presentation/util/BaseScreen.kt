package com.nubari.recipes.presentation.util

import com.nubari.recipes.R

sealed class BaseScreen(val name: String, val route: String, val root: String, val icon: Int) {
    object Feed : BaseScreen(
        name = "feed",
        route = "feed",
        root = "feed_root",
        icon = R.drawable.ic_feed
    )

    object Search : BaseScreen(
        name = "search",
        route = "search",
        root = "search_root",
        icon = R.drawable.ic_search
    )

    object Profile : BaseScreen(
        name = "profile",
        route = "profile",
        root = "profile_root",
        icon = R.drawable.ic_profile
    )
}

val navScreens = listOf(
    BaseScreen.Search,
    BaseScreen.Feed,
    BaseScreen.Profile
)
