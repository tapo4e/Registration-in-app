package com.example.registration.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.R
import com.example.registration.ui.theme.LightBlue
import kotlinx.coroutines.delay

@Composable
fun LoadScreen(modifier: Modifier = Modifier,
               navigate: () ->Unit) {
    val infiniteScale = rememberInfiniteTransition(label = "")
    val scale by infiniteScale.animateFloat(
        initialValue = 1f,
        targetValue = 1.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    LaunchedEffect(Unit){
        delay(3000)
        navigate()
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(80.dp)
                .background(Color.White)
        ) {
            val paint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                color = android.graphics.Color.WHITE
                setShadowLayer(
                    12.dp.toPx(),
                    0f,
                    2.dp.toPx(),
                    0x58585840
                )
            }
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawRoundRect(
                    0f, 0f, 80.dp.toPx(), 80.dp.toPx(), 14.dp.toPx(), 14.dp.toPx(), paint
                )
            }
            val sizeInside = Size(30.dp.toPx() * scale, 30.dp.toPx() * scale)
            drawRoundRect(
                color = LightBlue,
                size = sizeInside,
                topLeft = Offset(
                    x = center.x - sizeInside.width / 2,
                    y = center.y - sizeInside.height / 2
                ),
                cornerRadius = CornerRadius(
                    x = 5.dp.toPx() * scale,
                    y = 5.dp.toPx() * scale
                )
            )
        }
        Text(
            text = "Buyupix", modifier
                .align(Alignment.Center)
                .padding(top = 160.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight(500),
            color = LightBlue
        )
    }
}


@Preview
@Composable
fun LoadScreenPreview() {
    LoadScreen(){}
}