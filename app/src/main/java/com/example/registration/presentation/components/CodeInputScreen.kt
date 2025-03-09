package com.example.registration.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registration.data.OtpState
import com.example.registration.presentation.OtpAction
import com.example.registration.ui.theme.LightBlue
import com.example.registration.ui.theme.LightGray

@Composable
fun CodeInputScreen(
    state: OtpState,
    focusRequesters: List<FocusRequester>,
    onAction: (OtpAction) -> Unit,
    modifier: Modifier = Modifier,
    goEnd: () -> Unit,
    goBack: () -> Unit,
    resend: () -> Unit,
    isResend: Boolean,
    timeLeft: String
) {

    val focusManager = LocalFocusManager.current
    val keyboardManager = LocalSoftwareKeyboardController.current
    LaunchedEffect(state.focusedIndex) {
        state.focusedIndex?.let { index ->
            focusRequesters.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(state.code, keyboardManager) {
        val allNumbersEntered = state.code.none { it == null }
        if (allNumbersEntered) {
            focusRequesters.forEach {
                it.freeFocus()
            }
            focusManager.clearFocus()
            keyboardManager?.hide()
        }
    }

    Column(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.dp, top = 20.dp, end = 16.dp)
    ) {
        Spacer(modifier = modifier
            .size(8.dp, 16.dp)
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
                            width = 6f,
                            pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                            cap = StrokeCap.Round
                        )
                    )
                }
            }
            .clickable { goBack() }
        )
        Text(
            text = "Code",
            modifier
                .padding(top = 20.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight(500)
        )
        Text(
            text = "Enter the code you received",
            modifier.padding(top = 5.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = LightGray
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            state.code.forEachIndexed { index, number ->
                OtpInputField(
                    number = number,
                    focusRequester = focusRequesters[index],
                    onFocusChanged = { isFocused ->
                        if (isFocused) {
                            onAction(OtpAction.OnChangeFieldFocused(index))
                        }
                    },
                    onNumberChanged = { newNumber ->
                        onAction(OtpAction.OnEnterNumber(newNumber, index) { goEnd() })
                    },
                    onKeyboardBack = {
                        onAction(OtpAction.OnKeyboardBack)
                    },
                )
            }

        }
        Text(
            text = if (!isResend) {
                "No code received?"
            } else {
                "Resend the code in 0:$timeLeft"
            },
            modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .clickable(!isResend, onClick = {resend()}),
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            color = if (!isResend) {
                LightBlue
            } else {
                LightGray
            }
        )
//        state.isValid?.let { isValid ->
//            Text(
//                text = if(isValid) "OTP is valid!" else "OTP is invalid!",
//                color = if(isValid) Color.Green else Color.Red,
//                fontSize = 16.sp,
//                modifier = modifier.align(Alignment.CenterHorizontally)
//            )
//        }
    }

}

@Preview
@Composable
fun CodeInputScreenPreview() {
    CodeInputScreen(
        state = OtpState(),
        focusRequesters = List(6) { FocusRequester() },
        onAction = {}, goEnd = {}, goBack = {},
        resend = {}, isResend = true, timeLeft = ""
    )
}