package com.nubari.recipes.presentation.feed.state

import com.nubari.recipes.R
import com.nubari.recipes.domain.Meal

data class FeedState(
    val meals: List<Meal> = listOf(
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
    ),
    // TODO( ideally cookbooks should be a domain obj)
    val cookBooks: List<String> = listOf("Western", "Quick Lunch", "Veggies")
)
