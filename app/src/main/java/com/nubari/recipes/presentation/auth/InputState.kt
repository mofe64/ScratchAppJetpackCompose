package com.nubari.recipes.presentation.auth

data class InputState(
    val text: String = "",
    val isValid: Boolean = true,
    val type: InputType
)
