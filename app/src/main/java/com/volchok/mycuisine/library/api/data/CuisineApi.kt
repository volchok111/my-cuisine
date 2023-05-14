package com.volchok.mycuisine.library.api.data

import com.volchok.mycuisine.library.api.model.RecipeEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface CuisineApi {

    @GET("recipes/random?number=10")
    suspend fun getRecipe(@Header("X-RapidAPI-Host")host: String, @Header("X-RapidAPI-Key")key: String): RecipeEntity
}