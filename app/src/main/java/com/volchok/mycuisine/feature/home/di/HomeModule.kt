package com.volchok.mycuisine.feature.home.di

import com.volchok.mycuisine.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}