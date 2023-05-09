package com.volchok.mycuisine.app.di

import com.volchok.mycuisine.app.device.GlobalNavigationController
import com.volchok.mycuisine.app.domain.GoToHomeUseCase
import com.volchok.mycuisine.app.domain.GoToSearchUseCase
import com.volchok.mycuisine.app.domain.MainNavigationController
import com.volchok.mycuisine.app.domain.ObserveNavigationEventsUseCase
import com.volchok.mycuisine.app.presentation.MainViewModel
import com.volchok.mycuisine.app.presentation.SplashViewModel
import com.volchok.mycuisine.feature.home.domain.HomeNavigationController
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.binds
import org.koin.dsl.module

internal val mainModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::SplashViewModel)
    factory { ObserveNavigationEventsUseCase(get()) }

    single { GlobalNavigationController() }.binds(
        arrayOf(
            MainNavigationController::class,
            HomeNavigationController::class,
        )
    )

    factoryOf(::GoToHomeUseCase)
    factoryOf(::GoToSearchUseCase)
}