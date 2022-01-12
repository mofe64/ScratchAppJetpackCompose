package com.nubari.recipes.presentation.profile.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.profile.state.ProfileState

class ProfileViewModel : ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {
        //TODO (call repo functions to initialize recipes and followers in profile state)
    }

    fun createEvent() {}
    private fun onEvent() {}
}