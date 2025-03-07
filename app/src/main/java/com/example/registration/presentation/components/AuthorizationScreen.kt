package com.example.registration.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.R
import com.example.registration.ui.icons.Flag_of_Russia
import com.example.registration.ui.theme.LightBlue
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
                fontWeight = FontWeight(600),
                color = Color.Black

            )
            Text(
                text = "Enter your phone number. We will send you a confirmation code there",
                modifier.size(286.dp, 40.dp),
                fontSize = 14.sp,
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
                        painter = painterResource(id = R.drawable.russian_flag),
                        contentDescription = "Flag_of_Russia",
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 14.dp)
                            .size(27.dp)
                            .shadow(
                                4.dp,
                                shape = CircleShape,
                                ambientColor = Color.White,
                                spotColor = Color.Black
                            )
                    )
                    Text(
                        text = "+7", modifier
                            .align(Alignment.Center)
                            .padding(start = 30.dp),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                TextField(value = text,
                    onValueChange = { text = it },
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
                    placeholder = {
                        Text(
                            "Mobile number",
                            fontSize = 16.sp,
                            color = LightGray
                        )
                    }
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier
                    .padding(top = 20.dp)
                    .size(328.dp, 50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    LightBlue
                )

            ) {
                Text(text = "Continue",
                    fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen()
}

