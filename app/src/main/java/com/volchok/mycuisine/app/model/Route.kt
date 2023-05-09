package com.volchok.mycuisine.app.model

enum class Route {
    Splash,
    Home,
    Search;

    operator fun invoke() = name.lowercase()


    //TODO initial should be Splash Screen
    companion object {
        val Initial = Home
    }
}