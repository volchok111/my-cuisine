package com.volchok.mycuisine.app.system

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.volchok.mycuisine.ui.theme.MyCuisineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCuisineTheme {
                MainScreen()
            }
        }
    }
}