package com.volchok.mycuisine.app.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.mycuisine.app.domain.GoToHomeUseCase
import com.volchok.mycuisine.app.domain.GoToSearchUseCase
import com.volchok.mycuisine.app.domain.ObserveNavigationEventsUseCase
import com.volchok.mycuisine.app.model.ForwardNavigationEvent
import com.volchok.mycuisine.app.model.NavigationEvent
import com.volchok.mycuisine.app.model.Route
import com.volchok.mycuisine.library.mvvm.presentation.AbstractViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val observeNavigationEventsUseCase: ObserveNavigationEventsUseCase,
    private val goToSearchUseCase: GoToSearchUseCase,
    private val goToHomeUseCase: GoToHomeUseCase
) : AbstractViewModel<MainViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observeNavigationEventsUseCase(Unit).collect { onNavigationEvent(it) }
        }
    }

    private fun onNavigationEvent(navigationEvent: NavigationEvent) {
        state = state.copy(navigationEvent = navigationEvent)
    }

    fun onHome() {
        goToHomeUseCase(Unit)
    }

    fun onSearch() {
        goToSearchUseCase(Unit)
    }

    fun onNavigationEventConsumed() {
        state = state.copy(navigationEvent = null)
    }

    data class State(
        val navigationEvent: NavigationEvent? = ForwardNavigationEvent(Route.Initial)
    ) : AbstractViewModel.State
}