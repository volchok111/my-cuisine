package com.volchok.mycuisine.library.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CuisinePagerItem(
    imageUrl: String,
    time: String,
    title: String,
    rate: String,
) {
    Column(
        modifier = Modifier
            .padding(PaddingValues(horizontal = CuisineDimensions.sizeXS))
    ) {
        Card(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
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
                    backgroundColor = CuisineColors.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        CuisineText(
                            text = "$time min",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold,
                            color = CuisineColors.green500
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(CuisineDimensions.sizeXS))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            CuisineText(
                text = title,
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
                    tint = CuisineColors.green500
                )
                CuisineText(
                    text = rate,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    color = CuisineColors.green500
                )
            }
        }
    }
}

@Composable
fun CuisineItem(
    imageUrl: String,
    time: String,
    title: String,
    rate: String,
) {
    Column(
        modifier = Modifier
         .padding(PaddingValues(horizontal = CuisineDimensions.sizeXS))
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .width(200.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
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
                    backgroundColor = CuisineColors.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        CuisineText(
                            text = "$time min",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold,
                            color = CuisineColors.green500
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
                text = title,
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
                    tint = CuisineColors.green500
                )
                CuisineText(
                    text = rate,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    color = CuisineColors.green500
                )
            }
        }
    }
}