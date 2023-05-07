package com.volchok.mycuisine.app.di

import com.volchok.mycuisine.app.device.GlobalNavigationController
import com.volchok.mycuisine.app.domain.MainNavigationController
import com.volchok.mycuisine.app.domain.ObserveNavigationEventsUseCase
import com.volchok.mycuisine.app.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.binds
import org.koin.dsl.module

internal val mainModule = module {
    viewModelOf(::MainViewModel)
    factory { ObserveNavigationEventsUseCase(get()) }

    single { GlobalNavigationController() }.binds(
        arrayOf(
            MainNavigationController::class
        )
    )
}