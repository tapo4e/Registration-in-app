package com.example.registration.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.registration.presentation.components.AuthorizationScreen
import com.example.registration.presentation.components.CodeInputScreen
import com.example.registration.presentation.components.EndScreen
import com.example.registration.presentation.components.LoadScreen
import com.example.registration.presentation.components.OtpViewModel
import com.example.registration.presentation.components.SelectCountryScreen
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    private val screenViewModel by viewModels<ScreenViewModel>()
    private val viewModel by viewModels<OtpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val navController = rememberNavController()

            val state by viewModel.state.collectAsState()
            val focusRequesters = remember {
                List(6) { FocusRequester() }
            }
            NavHost(
                navController = navController,
                startDestination = "load_screen",
            ) {
                composable("load_screen") {
                    LoadScreen(navigate = {
                        navController.navigate("auth_screen") {
                            popUpTo("load_screen") {
                                inclusive = true
                            }
                        }
                    })
                }
                composable("auth_screen") {
                    AuthorizationScreen(
                        country = screenViewModel.countries[screenViewModel.country],
                        selectCountry = { navController.navigate("sel_country") },
                        sendCode = {
                            viewModel.sendVerificationCode(it, this@MainActivity)
                            viewModel.stateClear()
                            navController.navigate("code_screen")
                        })
                }
                composable("sel_country") {
                    SelectCountryScreen(
                        country = screenViewModel.countries,
                        id = screenViewModel.country,
                        onClick = { screenViewModel.changeCountry(it) },
                        goBack = {
                            navController.navigate("auth_screen") {
                                popUpTo("auth_screen") {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
                composable("code_screen") {
                    CodeInputScreen(
                        state = state,
                        focusRequesters = focusRequesters,
                        onAction = { action ->
                            when (action) {
                                is OtpAction.OnEnterNumber -> {
                                    if (action.number != null) {
                                        focusRequesters[action.index].freeFocus()
                                    }
                                }

                                else -> Unit
                            }
                            viewModel.onAction(action)
                        },
                        goEnd = { navController.navigate("end_screen") },
                        goBack = {
                            navController.navigate("auth_screen") {
                                popUpTo("auth_screen") {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable("end_screen") {
                    EndScreen()
                }
            }

        }
    }


}



