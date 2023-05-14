package com.volchok.mycuisine.library.api.di

import com.volchok.mycuisine.library.api.data.CuisineRepository
import com.volchok.mycuisine.library.api.data.CuisineApi
import com.volchok.mycuisine.library.api.domain.ObserveRecipesUseCase
import com.volchok.mycuisine.library.api.domain.RemoteRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CuisineApi::class.java)
    }
    factoryOf(::ObserveRecipesUseCase)

    factoryOf(::CuisineRepository) bind RemoteRepository::class
}