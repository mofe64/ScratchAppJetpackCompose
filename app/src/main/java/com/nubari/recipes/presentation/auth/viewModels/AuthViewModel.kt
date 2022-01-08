package com.nubari.recipes.presentation.auth.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.auth.AuthState

class AuthViewModel : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state
}