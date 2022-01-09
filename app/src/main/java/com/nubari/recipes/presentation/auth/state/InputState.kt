package com.nubari.recipes.presentation.auth.state

import com.nubari.recipes.presentation.auth.util.InputType

data class InputState(
    val text: String = "",
    val isValid: Boolean = true,
    val type: InputType
)
