package com.nubari.recipes.domain

import com.nubari.recipes.R

data class Recipe(
    val name: String,
    val image: Int,
    val ingredients: List<String> = listOf(
        "cooking spray",
        "1/2 cup whole milk",
        "2 large eggs",
        "1 tablespoon maple syrup",
        "1/2 teaspoon vanilla extract",
        "another ingredient",
        "another ingredient",
        "another ingredient",
    ),
    val steps: List<String> = listOf(
        "step 1",
        "step 2",
        "step 3",
        "step 4",
        "step 5",
        "step 6",
    ),
    val additionalInfo: List<String> = listOf(
        "info 1",
        "info 2",
        "info 2"
    ),
    val coverImage: Int = R.drawable.pizza,
    val images: List<Int> = listOf(
        R.drawable.prepimage1,
        R.drawable.prepimage2,
        R.drawable.prepimage3,
        R.drawable.bananaandmandarinbuns,
        R.drawable.cookedcoconutmussels
    )
)
