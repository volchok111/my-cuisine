package com.volchok.mycuisine.feature.home.system

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.volchok.mycuisine.feature.home.presentation.HomeViewModel
import com.volchok.mycuisine.library.ui.*
import com.volchok.mycuisine.library.ui.CuisineColors.background
import com.volchok.mycuisine.library.ui.CuisineColors.green500
import com.volchok.mycuisine.library.ui.CuisineDimensions.sizeM
import com.volchok.mycuisine.library.ui.CuisineDimensions.sizeS
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
            items(state.recipes.recipesEntity.take(10)) { item ->
                CuisineItem(
                    item = item,
                    goToRecipeDetails = {  }
                )
            }
        }
    }
}

@Composable
fun CuisineItem(
    item: HomeViewModel.State.RecipeItem,
    goToRecipeDetails: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(PaddingValues(horizontal = CuisineDimensions.sizeXS))
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .width(200.dp)
                .clickable { goToRecipeDetails() },
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = "Image",
                contentScale = ContentScale.Crop
            )
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .padding(end = CuisineDimensions.sizeXS, bottom = CuisineDimensions.sizeXS)
            ) {
                Card(
                    modifier = Modifier
                        .height(25.dp)
                        .width(80.dp),
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        CuisineText(
                            text = "${item.readyInMinutes} min",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold,
                            color = green500
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(CuisineDimensions.sizeXS))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(200.dp)
        ) {
            CuisineText(
                text = item.title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = CuisineDimensions.sizeXXS),
                    tint = green500
                )
                CuisineText(
                    text = item.aggregateLikes.toString(),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    color = green500
                )
            }
        }
    }
}