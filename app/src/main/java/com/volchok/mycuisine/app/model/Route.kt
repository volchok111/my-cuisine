package com.volchok.mycuisine.app.model

enum class Route {
    Splash;

    operator fun invoke() = name.lowercase()

    companion object {
        val Initial = Splash
    }
}