package com.nubari.recipes.presentation.util

sealed class Screen(val name: String, val route: String) {
    object LoginScreen: Screen(name = "login", route = "login")
    object RegisterScreen: Screen(name = "register", route = "register")
}
