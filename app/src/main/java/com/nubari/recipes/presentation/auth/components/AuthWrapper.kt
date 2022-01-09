package com.nubari.recipes.presentation.auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nubari.recipes.presentation.auth.screens.Login
import com.nubari.recipes.presentation.auth.screens.Register
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel

@Composable
fun AuthenticationWrapper(
    viewModel: AuthViewModel
) {
    val authState = viewModel.state.value

    if (authState.inLoginMode) {
        Login()
    } else {
        Register()
    }
}