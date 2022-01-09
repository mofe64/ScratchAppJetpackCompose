package com.nubari.recipes.presentation.auth.events

sealed class AuthEvent {
    object SwitchToRegister : AuthEvent()
    object SwitchToLogin : AuthEvent()
    data class Login(
        val email: String,
        val password: String
    ) : AuthEvent()

    data class Register(
        val name: String,
        val email: String,
        val password: String
    ) : AuthEvent()

}