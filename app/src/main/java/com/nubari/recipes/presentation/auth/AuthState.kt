package com.nubari.recipes.presentation.auth

data class AuthState(
    val isAuthenticated: Boolean = false,
    var authDetails: Map<String, String>? = null,
    val inLoginMode: Boolean = true,
    val isProcessing: Boolean = false
)


