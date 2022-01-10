package com.nubari.recipes.presentation.feed.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nubari.recipes.presentation.feed.state.FeedState

class FeedViewModel : ViewModel() {
    private val _state = mutableStateOf(FeedState())
    val state: State<FeedState> = _state

    init {
        //TODO (call repo functions to initialize meals and cookbooks in feed state)
    }

    fun createEvent() {}
    private fun onEvent() {}
}