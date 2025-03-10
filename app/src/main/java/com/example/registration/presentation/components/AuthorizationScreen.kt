package com.example.registration.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.R
import com.example.registration.data.Country
import com.example.registration.ui.theme.LightBlue
import com.example.registration.ui.theme.LightGray
import com.example.registration.ui.theme.LightGray2

@SuppressLint("SuspiciousIndentation")
@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    country: Country,
    selectCountry: () -> Unit,
    sendCode: (phone: String) -> Unit
) {
    var isEdit by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    Column(
        modifier
            .background(Color.White)
            .padding(start = 16.dp, top = 20.dp, end = 16.dp)
            .fillMaxSize()


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
                .height(52.dp)

        ) {
            Box(modifier = modifier
                .fillMaxHeight()
                .width(90.dp)
                .clip(RoundedCornerShape(10.dp))
                .drawBehind {
                    drawRoundRect(
                        color = LightGray2,
                        topLeft = Offset.Zero,
                        size = Size(90.dp.toPx(), 52.dp.toPx()),
                        cornerRadius = CornerRadius(10.dp.toPx(), 10.dp.toPx())
                    )

                }
                .clickable { selectCountry() }) {
                Image(
                    painter = painterResource(id = country.png),
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
                    text = country.number,
                    modifier
                        .align(Alignment.Center)
                        .padding(start = 30.dp),
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            TextField(value = text,
                onValueChange = {
                    if(it.length<=country.size)
                    text = it
                    isEdit = country.regex.matches(text)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
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
                        "Mobile number", fontSize = 16.sp, color = LightGray
                    )
                })
        }
        Button(
            onClick = { sendCode(country.number + text) },
            modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                LightBlue
            ),
            enabled = isEdit

        ) {
            Text(
                text = "Continue", fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen(country = Country("", "+375", R.drawable.belarus_flag, Regex(""),10),
        selectCountry = {},
        sendCode = {})
}

