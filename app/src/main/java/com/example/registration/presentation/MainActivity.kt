package com.example.registration.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.example.registration.presentation.components.AuthorizationScreen
import com.example.registration.presentation.components.CodeInputScreen
import com.example.registration.presentation.components.LoadScreen
import com.example.registration.presentation.components.OtpViewModel
import com.example.registration.presentation.components.SelectCountryScreen

class MainActivity : ComponentActivity() {

    private val screenViewModel by viewModels<ScreenViewModel>()
    private val viewModel by viewModels<OtpViewModel>()
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state by viewModel.state.collectAsState()
            val focusRequesters = remember {
                List(6) { FocusRequester() }
            }

//            AuthorizationScreen()
            CodeInputScreen(
                state = state,
                focusRequesters = focusRequesters,
                onAction = { action ->
                    when(action) {
                        is OtpAction.OnEnterNumber -> {
                            if(action.number != null) {
                                focusRequesters[action.index].freeFocus()
                            }
                        }
                        else -> Unit
                    }
                    viewModel.onAction(action)
                },
            )

//            SelectCountryScreen(
//                country = screenViewModel.countries,
//                id = screenViewModel.country,
//                onClick = {screenViewModel.changeCountry(it)}
//            )
        }
    }
}
