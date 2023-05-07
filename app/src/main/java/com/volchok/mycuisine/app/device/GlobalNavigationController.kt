package com.volchok.mycuisine.app.device

import com.volchok.mycuisine.app.domain.MainNavigationController
import com.volchok.mycuisine.app.model.BackNavigationEvent
import com.volchok.mycuisine.app.model.ForwardNavigationEvent
import com.volchok.mycuisine.app.model.NavigationEvent
import com.volchok.mycuisine.app.model.Route
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class GlobalNavigationController : MainNavigationController {

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    override val navigationEvent = _navigationEvent.asSharedFlow()

    override fun goBack() = goTo(BackNavigationEvent)

    override fun goToSplash() = goTo(Route.Splash)

    private fun goTo(route: Route) = goTo(ForwardNavigationEvent(route))

    private fun goTo(navigationEvent: NavigationEvent) {
        _navigationEvent.tryEmit(navigationEvent)
    }
}