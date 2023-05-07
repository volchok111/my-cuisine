package com.volchok.mycuisine.app.domain

import com.volchok.mycuisine.app.model.NavigationEvent
import com.volchok.mycuisine.library.use_case.domain.SynchronousUseCase
import kotlinx.coroutines.flow.Flow

class ObserveNavigationEventsUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Flow<NavigationEvent>> {

    override fun invoke(input: Unit): Flow<NavigationEvent> =
        mainNavigationController.navigationEvent
}