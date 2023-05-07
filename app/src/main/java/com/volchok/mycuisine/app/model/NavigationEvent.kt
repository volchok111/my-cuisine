package com.volchok.mycuisine.app.model

typealias ForwardNavigationEvent = NavigationEvent.ForwardEvent
typealias PopUpNavigationEvent = NavigationEvent.PopUpEvent
typealias BackNavigationEvent = NavigationEvent.BackEvent

sealed interface NavigationEvent {

    data class ForwardEvent(
        val route: Route,
        val clearBackStack: Boolean = false,
        val clearBackStackRoute: Route? = null
    ) : NavigationEvent

    data class PopUpEvent(
        val route: Route,
        val inclusive: Boolean = false,
    ) : NavigationEvent

    object BackEvent : NavigationEvent
}
