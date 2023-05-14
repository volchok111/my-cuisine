package com.volchok.mycuisine.library.api.data

import com.volchok.mycuisine.library.api.domain.RemoteRepository
import com.volchok.mycuisine.library.api.model.RecipeEntity
import com.volchok.mycuisine.library.data.model.Data

class CuisineRepository(
    private val cuisineApi: CuisineApi
) : RemoteRepository {
    override suspend fun getRecipes(): Data<RecipeEntity> {
        return try {
            val result = cuisineApi.getRecipe(API_HOST, API_KEY)
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(cause = ex)
        }
    }

    companion object {
        private const val API_HOST = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com"
        private const val API_KEY = "2f95872471mshda35e3be08b37f5p18f5e5jsn69680e02a3f7"
    }
}