package com.volchok.mycuisine.library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.volchok.mycuisine.R
import com.volchok.mycuisine.library.ui.CuisineColors.blue
import com.volchok.mycuisine.library.ui.CuisineColors.chrome900
import com.volchok.mycuisine.library.ui.CuisineColors.white

@Composable
fun CuisineAlertDialog(
    title: String,
    onDismiss: () -> Unit,
    positiveButtonText: String,
    modifier: Modifier = Modifier,
    onPositiveButtonClick: () -> Unit = onDismiss,
    message: String? = null,
    negativeButtonText: String? = null,
    onNegativeButtonClick: (() -> Unit) = onDismiss,
    neutralButtonText: String? = null,
    onNeutralButtonClick: (() -> Unit) = onDismiss,
    dialogProperties: DialogProperties = DialogProperties()
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = dialogProperties
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(CuisineDimensions.sizeXXS),
            color = white,
            contentColor = chrome900
        ) {
            Column(
                modifier = Modifier.padding(CuisineDimensions.sizeXS)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(CuisineDimensions.sizeS)
                )
                if (!message.isNullOrEmpty()) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(CuisineDimensions.sizeS)
                    )
                }
                Spacer(modifier = Modifier.height(CuisineDimensions.sizeXS))
                Row {
                    neutralButtonText?.let {
                        CuisineActionButton(
                            text = it,
                            onClick = onNeutralButtonClick
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    negativeButtonText?.let {
                        CuisineActionButton(
                            text = it,
                            onClick = onNegativeButtonClick
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = CuisineDimensions.sizeXXS),
                        contentAlignment = BottomEnd
                    ) {
                        CuisineText(
                            text = positiveButtonText,
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier
                                .clickable { onPositiveButtonClick() }
                                .padding(end = CuisineDimensions.sizeXS),
                            color = blue,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(CuisineDimensions.sizeXXS))
            }
        }
    }
}

@Composable
fun CuisineLoadingDialog(
    title: String,
    modifier: Modifier = Modifier,
    text: String? = null,
    onDismiss: () -> Unit,
    dialogProperties: DialogProperties = DialogProperties()
) {
    val isLoading by remember { mutableStateOf(true) }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isLoading,
        iterations = 1000
    )
    Dialog(
        onDismissRequest = onDismiss,
        properties = dialogProperties
    ) {
        Surface(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(CuisineDimensions.sizeS),
            color = white,
            contentColor = chrome900
        ) {
            Column(
                modifier = Modifier.padding(CuisineDimensions.sizeM)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h2
                )
                if (!text.isNullOrEmpty()) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(top = CuisineDimensions.sizeL)
                    )
                }
                Spacer(modifier = Modifier.height(CuisineDimensions.sizeM))
//                CircularProgressIndicator(
//                    color = blue,
//                    modifier = Modifier.align(CenterHorizontally),
//                )
                LottieAnimation(
                    composition = composition,
                    progress = { progress })
                Spacer(modifier = Modifier.height(CuisineDimensions.sizeXXS))
            }
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    CuisineLoadingDialog(title = "", onDismiss = {  })
}