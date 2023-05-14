package com.volchok.mycuisine.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.mycuisine.library.api.domain.ObserveRecipesUseCase
import com.volchok.mycuisine.library.api.model.RecipeEntity
import com.volchok.mycuisine.library.api.model.RecipeModel
import com.volchok.mycuisine.library.data.model.Data
import com.volchok.mycuisine.library.mvvm.presentation.AbstractViewModel
import com.volchok.mycuisine.library.use_case.domain.invoke
import kotlinx.coroutines.launch

class HomeViewModel(
    private val observeRecipesUseCase: ObserveRecipesUseCase
) : AbstractViewModel<HomeViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observeRecipesUseCase().collect {
                if (it is Data.Success) {
                    state = state.copy(recipes = it.value.toItem())
                }
            }
        }
    }

    private fun RecipeModel.toRecipeItem() = State.RecipeItem(
        title = title,
        id = id,
        image = image,
        sourceUrl = sourceUrl,
        readyInMinutes = readyInMinutes,
        aggregateLikes = aggregateLikes,
        instructions = instructions,
        servings = servings,
    )

    private fun RecipeEntity.toItem() = State.RecipeEntity(
        recipesEntity = recipes.map { it.toRecipeItem() }
    )

    data class State(
        val loading: Boolean = false,
        val pageCount: Int = 10,
        val recipes: RecipeEntity = RecipeEntity()
    ) : AbstractViewModel.State {

        data class RecipeItem(
            val aggregateLikes: Int = 0,
            val id: Int = 0,
            val image: String = "",
            val instructions: String = "",
            val readyInMinutes: Int = 0,
            val servings: Int = 0,
            val sourceUrl: String = "",
            val title: String = "",
        )

        data class RecipeEntity(
            val recipesEntity: List<RecipeItem> = emptyList()
        )
    }
}