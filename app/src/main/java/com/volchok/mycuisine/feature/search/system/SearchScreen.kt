package com.volchok.mycuisine.feature.search.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.volchok.mycuisine.library.ui.CuisineColors

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CuisineColors.background),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Search Screen")
    }
}