package com.volchok.mycuisine.library.api.model

data class RecipeModel(
    val aggregateLikes: Int,
    // val analyzedInstructions: List<AnalyzedInstruction>,
    val id: Int,
    val image: String,
    val instructions: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String,
)