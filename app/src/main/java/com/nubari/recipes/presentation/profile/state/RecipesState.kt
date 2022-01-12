package com.nubari.recipes.presentation.profile.state

import com.nubari.recipes.R
import com.nubari.recipes.domain.Recipe

data class RecipesState(
    val recipes: List<Recipe> = listOf(
        Recipe(
            "Banana and Mandarin buns",
            R.drawable.bananaandmandarinbuns
        ),
        Recipe(
            "Cooked Coconut Mussels",
            R.drawable.cookedcoconutmussels
        ),
        Recipe(
            "Fancy",
            R.drawable.feedimage2
        ),
        Recipe(
            "Italian",
            R.drawable.pizza
        ),
    ),
    val isListVisible : Boolean = false
)
