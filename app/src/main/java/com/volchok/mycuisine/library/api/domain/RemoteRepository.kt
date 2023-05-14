package com.volchok.mycuisine.library.api.domain

import com.volchok.mycuisine.library.api.model.RecipeEntity
import com.volchok.mycuisine.library.data.model.Data

interface RemoteRepository {

    suspend fun getRecipes(): Data<RecipeEntity>
}