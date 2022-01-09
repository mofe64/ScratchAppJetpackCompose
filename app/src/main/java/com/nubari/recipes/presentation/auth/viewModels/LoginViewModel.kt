package com.nubari.recipes.presentation.auth.viewModels

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.auth.InputState
import com.nubari.recipes.presentation.auth.InputType
import com.nubari.recipes.presentation.auth.LoginEvent

class LoginViewModel : ViewModel() {
//    val TAG = "LoginViewModel"
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

    fun createEvent(event: LoginEvent) {
//        Log.i(TAG, "create event called")
        onEvent(event)
    }


    private fun onEvent(event: LoginEvent) {
//        Log.i(TAG, "onEvent called")
//        Log.i(TAG, event.toString())
        when (event) {
            is LoginEvent.EnteredEmail -> {
                _email.value = email.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.ChangedEmailFocus -> {
                _email.value = email.value.copy(
                    isValid = validateInput(email.value.text, InputType.EMAIL)
                )
            }
            is LoginEvent.EnteredPassword -> {
                _password.value = password.value.copy(
                    text = event.value
                )
            }
            is LoginEvent.ChangedPasswordFocus -> {
                _password.value = password.value.copy(
                    isValid = validateInput(email.value.text, InputType.PASSWORD)
                )
            }
            is LoginEvent.Submit -> {}
        }
    }

    private fun validateInput(inputValue: String, inputType: InputType): Boolean {
//        Log.i(TAG, "Validate called")
//        Log.i(TAG,inputValue )
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