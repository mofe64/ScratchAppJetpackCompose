package com.nubari.recipes.presentation.auth.events

import androidx.compose.ui.focus.FocusState

sealed class RegistrationEvent {
    data class EnteredName(val value: String) : RegistrationEvent()
    data class ChangedNameFocus(val focusState: FocusState) : RegistrationEvent()
    data class EnteredEmail(val value: String) : RegistrationEvent()
    data class ChangedEmailFocus(val focusState: FocusState) : RegistrationEvent()
    data class EnteredPassword(val value: String) : RegistrationEvent()
    data class ChangedPasswordFocus(val focusState: FocusState) : RegistrationEvent()

}
