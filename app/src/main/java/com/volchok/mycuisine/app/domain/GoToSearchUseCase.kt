package com.volchok.mycuisine.app.domain

import com.volchok.mycuisine.library.use_case.domain.SynchronousUseCase

class GoToSearchUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Unit>{
    override fun invoke(input: Unit) {
        mainNavigationController.goToSearch()
    }
}