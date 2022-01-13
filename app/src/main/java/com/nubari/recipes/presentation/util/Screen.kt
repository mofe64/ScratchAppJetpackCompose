package com.nubari.recipes.presentation.util

sealed class Screen(val name: String, val route: String) {
    object MyRecipesScreen : Screen(name = "my recipes", route = "my_recipes")
    object SavedRecipesScreen : Screen(name = "saved recipes", route = "saved_recipes")
    object RecipeDetailScreen : Screen(name = "recipe details", route = "recipe_details")
}
