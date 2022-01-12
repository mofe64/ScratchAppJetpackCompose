package com.nubari.recipes.presentation.profile.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.profile.events.RecipesEvents
import com.nubari.recipes.presentation.profile.state.RecipesState

class RecipesViewModel : ViewModel() {
    private val _state = mutableStateOf(RecipesState())
    val state = _state

    fun createEvent(event: RecipesEvents) {
        onEvent(event = event)
    }

    private fun onEvent(event: RecipesEvents) {
        when (event) {
            is RecipesEvents.ToggleListVisibility -> {
                _state.value = state.value.copy(
                    isListVisible = !state.value.isListVisible
                )
            }
            is RecipesEvents.AddRecipe -> {}
        }
    }
}