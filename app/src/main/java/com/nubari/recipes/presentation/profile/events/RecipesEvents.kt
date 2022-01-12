package com.nubari.recipes.presentation.profile.events

sealed class RecipesEvents {
    object ToggleListVisibility : RecipesEvents()
    object AddRecipe : RecipesEvents()
}