package com.volchok.mycuisine.app.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.mycuisine.app.domain.GoToHomeUseCase
import com.volchok.mycuisine.library.mvvm.presentation.AbstractViewModel
import kotlinx.coroutines.launch

class SplashViewModel(
    private val goToHomeUseCase: GoToHomeUseCase
) : AbstractViewModel<SplashViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            goToHomeUseCase(Unit)
        }
    }

    data class State(
        val test: String = ""
    ) : AbstractViewModel.State
}