package com.nubari.recipes.presentation.profile.state

import com.nubari.recipes.R
import com.nubari.recipes.domain.Recipe

data class ProfileState(
    val myRecipes: List<Recipe> = listOf(
        Recipe(
            "Sweets",
            R.drawable.sweets
        ),
        Recipe(
            "Italian",
            R.drawable.pizza
        ),
        Recipe(
            "Deserts",
            R.drawable.strawberries
        ),
        Recipe(
            "Fancy",
            R.drawable.feedimage2
        ),
        Recipe(
            "Italian",
            R.drawable.pizza
        ),
        Recipe(
            "Sweets",
            R.drawable.sweets
        ),
    ),
    val savedRecipes: List<Recipe> = listOf(
        Recipe(
            "Sweets",
            R.drawable.sweets
        ),
        Recipe(
            "Italian",
            R.drawable.pizza
        ),
    ),
    val followers: List<String> = emptyList(),
)
