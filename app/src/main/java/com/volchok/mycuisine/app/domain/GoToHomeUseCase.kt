package com.volchok.mycuisine.app.domain

import com.volchok.mycuisine.library.use_case.domain.SynchronousUseCase

class GoToHomeUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Unit>{
    override fun invoke(input: Unit) {
        mainNavigationController.goToHome()
    }
}