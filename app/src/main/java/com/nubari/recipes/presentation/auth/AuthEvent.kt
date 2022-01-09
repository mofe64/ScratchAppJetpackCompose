package com.nubari.recipes.presentation.auth

sealed class AuthEvent {
    object switchToRegister : AuthEvent()
    object switchToLogin : AuthEvent()
}