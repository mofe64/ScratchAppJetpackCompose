package com.nubari.recipes.presentation.auth

import androidx.compose.ui.focus.FocusState

sealed class LoginEvent {
    data class EnteredEmail(val value: String) : LoginEvent()
    data class ChangedEmailFocus(val focusState: FocusState) : LoginEvent()
    data class EnteredPassword(val value: String) : LoginEvent()
    data class ChangedPasswordFocus(val focusState: FocusState) : LoginEvent()
    object Submit : LoginEvent()
}
