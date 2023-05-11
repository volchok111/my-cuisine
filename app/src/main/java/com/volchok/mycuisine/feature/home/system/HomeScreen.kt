package com.volchok.mycuisine.feature.home.system

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.volchok.mycuisine.feature.home.presentation.HomeViewModel
import com.volchok.mycuisine.library.ui.CuisineColors.background
import com.volchok.mycuisine.library.ui.CuisineColors.green500
import com.volchok.mycuisine.library.ui.CuisineDimensions.sizeM
import com.volchok.mycuisine.library.ui.CuisineDimensions.sizeS
import com.volchok.mycuisine.library.ui.CuisineItem
import com.volchok.mycuisine.library.ui.CuisinePagerItem
import com.volchok.mycuisine.library.ui.CuisineText
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val state = viewModel.states.collectAsState()

    HomeScreenImpl(
        state = state.value
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenImpl(
    state: HomeViewModel.State,
) {
    val pagerState = rememberPagerState(initialPage = 0)
    val image =
        "https://www.blueosa.com/wp-content/uploads/2020/01/the-best-top-10-indian-dishes.jpg"

    LaunchedEffect(key1 = Unit) {
        while (true) {
            yield()
            delay(3000)
            try {
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (state.pageCount),
                    animationSpec = tween(600)
                )
            } catch (_: Throwable) {
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(sizeS)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            CuisineText(
                text = "Previously ordered",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = green500
            )
        }

        Spacer(modifier = Modifier.height(sizeS))
        HorizontalPager(
            pageCount = state.pageCount,
            state = pagerState,
        ) {
            CuisinePagerItem(
                imageUrl = image,
                time = "20",
                title = "Pasta",
                rate = "4.2"
            )
        }

        Spacer(modifier = Modifier.height(sizeM))
        LazyRow {
            items(10) { item ->
                CuisineItem(imageUrl = image, time = "10", title = "Top", rate = "0.0")
            }
        }
    }
}