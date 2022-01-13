package com.nubari.recipes.presentation.recipes.state

import com.nubari.recipes.R
import com.nubari.recipes.domain.Recipe

data class RecipeDetailState(
    val recipe: Recipe = Recipe(
        name = "Engine Cooked Honey Orange Pancake",
        image = R.drawable.orangepancake
    )
)
