package com.nubari.recipes.presentation.recipes.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.recipes.state.RecipeDetailState

class RecipeDetailViewModel : ViewModel() {
    private val _state = mutableStateOf(RecipeDetailState())
    val state = _state

}