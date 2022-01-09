package com.nubari.recipes.presentation.auth.viewModels

import android.text.TextUtils
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.auth.events.RegistrationEvent
import com.nubari.recipes.presentation.auth.state.InputState
import com.nubari.recipes.presentation.auth.util.InputType

class RegisterViewModel : ViewModel() {

    private val _fullName = mutableStateOf(
        InputState(
            type = InputType.TEXT
        )
    )
    val fullName: State<InputState> = _fullName

    private val _email = mutableStateOf(
        InputState(
            type = InputType.EMAIL
        )
    )
    val email: State<InputState> = _email

    private val _password = mutableStateOf(
        InputState(
            type = InputType.PASSWORD
        )
    )
    val password: State<InputState> = _password

    fun createEvent(event: RegistrationEvent) {
        onEvent(event)
    }

    private fun onEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.EnteredName -> {
                _fullName.value = fullName.value.copy(
                    text = event.value
                )
            }
            is RegistrationEvent.ChangedNameFocus -> {
                _fullName.value = fullName.value.copy(
                    isValid = validateInput(email.value.text, InputType.TEXT)
                )
            }
            is RegistrationEvent.EnteredEmail -> {
                _email.value = email.value.copy(
                    text = event.value
                )
            }
            is RegistrationEvent.ChangedEmailFocus -> {
                _email.value = email.value.copy(
                    isValid = validateInput(email.value.text, InputType.EMAIL)
                )
            }
            is RegistrationEvent.EnteredPassword -> {
                _password.value = password.value.copy(
                    text = event.value
                )
            }
            is RegistrationEvent.ChangedPasswordFocus -> {
                _password.value = password.value.copy(
                    isValid = validateInput(email.value.text, InputType.PASSWORD)
                )
            }
        }
    }

    private fun validateInput(inputValue: String, inputType: InputType): Boolean {
        return when (inputType) {
            InputType.EMAIL -> {
                !TextUtils.isEmpty(inputValue) && android.util.Patterns.EMAIL_ADDRESS.matcher(
                    inputValue
                ).matches()
            }
            InputType.PASSWORD -> {
                !TextUtils.isEmpty(inputValue) && inputValue.length > 5
            }
            InputType.TEXT -> {
                !TextUtils.isEmpty(inputValue)
            }
        }
    }

}