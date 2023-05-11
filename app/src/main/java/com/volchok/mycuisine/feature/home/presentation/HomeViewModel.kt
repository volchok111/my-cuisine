package com.volchok.mycuisine.feature.home.presentation

import com.volchok.mycuisine.library.mvvm.presentation.AbstractViewModel

class HomeViewModel : AbstractViewModel<HomeViewModel.State>(State()) {

    data class State(
        val loading: Boolean = false,
        val pageCount: Int = 10,
        val id: String? = null
    ) : AbstractViewModel.State
}