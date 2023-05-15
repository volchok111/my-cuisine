package com.volchok.mycuisine.library.api.domain

import com.volchok.mycuisine.library.api.model.RecipeEntity
import com.volchok.mycuisine.library.data.model.Data
import com.volchok.mycuisine.library.use_case.domain.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ObserveRecipesUseCase(
    private val repository: RemoteRepository
) : SuspendUseCase<Unit, Flow<Data<RecipeEntity>>> {
    override suspend fun invoke(input: Unit): Flow<Data<RecipeEntity>> = flow {
        emit(repository.getRecipes())
    }
}