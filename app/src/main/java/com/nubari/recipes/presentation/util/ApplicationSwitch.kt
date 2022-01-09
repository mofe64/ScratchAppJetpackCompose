package com.nubari.recipes.presentation.util

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nubari.recipes.presentation.application.RecipeApplication
import com.nubari.recipes.presentation.auth.components.AuthenticationWrapper
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel

@Composable
fun ApplicationSwitch(
    authViewModel: AuthViewModel = viewModel()
) {
    val authState = authViewModel.state.value

    if (authState.isAuthenticated) {
        RecipeApplication()
    } else {
        AuthenticationWrapper(viewModel = authViewModel)
    }
}