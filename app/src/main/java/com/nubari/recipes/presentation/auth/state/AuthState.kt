package com.nubari.recipes.presentation.auth.state

data class AuthState(
    val isAuthenticated: Boolean = true,
    var authDetails: Map<String, String>? = null,
    val inLoginMode: Boolean = true,
    val isProcessing: Boolean = false
)


