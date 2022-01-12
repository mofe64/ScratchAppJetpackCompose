package com.nubari.recipes.presentation.feed.state

import com.nubari.recipes.R
import com.nubari.recipes.domain.Recipe

data class FeedState(
    val recipes: List<Recipe> = listOf(
        Recipe(
            "Vanilla Pud",
            R.drawable.feedimage2
        ),
        Recipe(
            "White Wine Toffee",
            R.drawable.feedimage1
        ),
        Recipe(
            "Vanilla Pud",
            R.drawable.feedimage2
        ),
        Recipe(
            "White Wine Toffee",
            R.drawable.feedimage1
        ),
    ),
    // TODO( ideally cookbooks should be a domain obj)
    val cookBooks: List<String> = listOf("Western", "Quick Lunch", "Veggies")
)
