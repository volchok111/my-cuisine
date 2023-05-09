package com.volchok.mycuisine.app.domain

import com.volchok.mycuisine.app.model.NavigationEvent
import kotlinx.coroutines.flow.Flow

interface MainNavigationController {
    val navigationEvent: Flow<NavigationEvent>

    fun goBack()

    fun goToSplash()

    fun goToHome()

    fun goToSearch()

}