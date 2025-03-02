package com.example.registration.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.R
import com.example.registration.ui.theme.LightGray
import com.example.registration.ui.theme.LightGray2

@Composable
fun AuthorizationScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Box(
        modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 20.dp)
        ) {
            Text(
                text = "Let's get started",
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(700),
                color = Color.Black

            )
            Text(
                text = "Enter your phone number. We will send you a confirmation code there",
                modifier.size(286.dp, 40.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(400),
                color = LightGray
            )
            Row(
                modifier
                    .padding(top = 20.dp)
                    .size(328.dp, 52.dp)
            ) {
                Box(modifier = modifier
                    .fillMaxHeight()
                    .width(75.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = LightGray2,
                            topLeft = Offset.Zero,
                            size = Size(75.dp.toPx(), 52.dp.toPx()),
                            cornerRadius = CornerRadius(10.dp.toPx(), 10.dp.toPx())
                        )

                    }) {
                    Image(
                        imageVector = Flag_of_Russia,
                        contentDescription = "Flag_of_Russia",
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 14.dp)
                            .size(24.dp, 24.dp)
                            .shadow(
                                4.dp,
                                shape = CircleShape,
                                ambientColor = Color.White,
                                spotColor = Color.Black
                            )
                    )
                    Text(text = "+7", modifier
                        .align(Alignment.Center)
                        .padding(start = 30.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = Color.Black)
                }
                TextField(value = text,
                    onValueChange ={text=it},
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        focusedContainerColor = LightGray2,
                        unfocusedContainerColor = LightGray2,
                        disabledContainerColor = LightGray2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,

                        ),
                    modifier = modifier
                        .padding(start = 10.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    placeholder = {Text("asd")}
                        )
            }
        }
    }
}

@Preview
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen()
}

val Flag_of_Russia: ImageVector
    get() {
        if (_Flag_of_Russia != null) {
            return _Flag_of_Russia!!
        }
        _Flag_of_Russia = ImageVector.Builder(
            name = "Flag_of_Russia",
            defaultWidth = 900.dp,
            defaultHeight = 600.dp,
            viewportWidth = 9f,
            viewportHeight = 6f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 0f)
                horizontalLineTo(9f)
                verticalLineTo(3f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD52B1E)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 3f)
                horizontalLineTo(9f)
                verticalLineTo(6f)
                horizontalLineTo(0f)
                verticalLineTo(3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF0039A6)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 2f)
                horizontalLineTo(9f)
                verticalLineTo(4f)
                horizontalLineTo(0f)
                verticalLineTo(2f)
                close()
            }
        }.build()
        return _Flag_of_Russia!!
    }

private var _Flag_of_Russia: ImageVector? = null