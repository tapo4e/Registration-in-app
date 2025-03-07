package com.example.registration.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.R
import com.example.registration.data.Country
import com.example.registration.ui.theme.LightGray
import com.example.registration.ui.theme.LightGray2

@Composable
fun SelectCountryScreen(
    modifier: Modifier = Modifier,
    country: List<Country>,
    id: Int,
    onClick:(id:Int) ->Unit
) {

    Column(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.dp, top = 25.dp)
    ) {
        Box(
            modifier
                .clickable { }
                .clip(CircleShape)
                .size(24.dp)
                .background(LightGray2)

        )
        {
            Spacer(modifier = modifier
                .align(Alignment.Center)
                .padding(end = 2.dp)
                .size(6.dp, 12.dp)
                .drawWithCache {
                    val path = Path()
                    path.moveTo(size.width, 0f)
                    path.lineTo(0f, size.height / 2f)
                    path.lineTo(size.width, size.height)
                    onDrawBehind {
                        drawPath(
                            path,
                            color = Color.Black,
                            style = Stroke(
                                width = 4f,
                                pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }

            )
        }
        Text(
            "Country",
            modifier.padding(top = 10.dp),
            fontWeight = FontWeight(500),
            fontSize = 32.sp
        )
        LazyColumn {
            items(country.size) {
                    Row(
                        modifier
                            .padding(top = 10.dp)
                            .size(328.dp, 64.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable(indication = rememberRipple(true),
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = { onClick(it) }),


                    ) {
                        Image(
                            painter = painterResource(id = country[it].png),
                            contentDescription = null,
                            modifier
                                .size(40.dp)
                                .shadow(
                                    4.dp,
                                    shape = CircleShape,
                                    ambientColor = Color.White,
                                    spotColor = Color.Black
                                )
                        )
                        Column(modifier.padding(start = 15.dp)) {
                            Text(
                                text = country[it].name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(500)
                            )
                            Text(
                                text = country[it].number,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = LightGray
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        AnimatedVisibility(
                            visible = it == id,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.check),
                                contentDescription = null,
                                modifier
                                    .size(24.dp)
                            )
                        }
                    }

            }
        }
    }

}

@Preview
@Composable
fun SelectCountryScreenPreview() {
    val countries = listOf<Country>(
        Country("Belarus", "+375", R.drawable.belarus_flag),
        Country("Russia", "+7", R.drawable.russian_flag),
        Country("USA", "+1", R.drawable.american_flag)
    )
    SelectCountryScreen(country = countries, id = 0, onClick = {})
}