package com.volchok.mycuisine.library.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CuisineBottomBar(
    onHome: () -> Unit,
    onSearch: () -> Unit,
) {
    BottomNavigation(
        backgroundColor = CuisineColors.green300
    ) {
        BottomBarItem(
            icon = Icons.Default.Home,
            selected = false,
            onClick = { onHome() }
        )
        BottomBarItem(
            icon = Icons.Default.Search,
            selected = false,
            onClick = { onSearch() }
        )
    }
}

@Composable
private fun RowScope.BottomBarItem(
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { onClick() },
        icon = {
            Image(
                imageVector = icon,
                contentDescription = "Icon",
                colorFilter = ColorFilter.tint(CuisineColors.background)
            )
        }
    )
}