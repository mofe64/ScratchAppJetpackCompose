package com.nubari.recipes.presentation.auth.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nubari.recipes.presentation.auth.AuthEvent
import com.nubari.recipes.presentation.auth.AuthState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    fun createEvent(event: AuthEvent) {
        onEvent(event)
    }

    private fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.SwitchToLogin -> {
                _state.value = state.value.copy(
                    inLoginMode = true
                )
            }
            is AuthEvent.SwitchToRegister -> {
                _state.value = state.value.copy(
                    inLoginMode = false
                )
            }
            is AuthEvent.Login -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        isProcessing = true
                    )
                    delay(5000)
                    _state.value = state.value.copy(
                        isProcessing = false,
                        isAuthenticated = true,
                    )

                }
            }
            is AuthEvent.Register -> {
                viewModelScope.launch {
                    delay(5000)
                    _state.value = state.value.copy(
                        isAuthenticated = true
                    )

                }
            }
        }
    }
}