package com.example.registration.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.registration.presentation.components.AuthorizationScreen
import com.example.registration.presentation.components.LoadScreen
import com.example.registration.presentation.components.SelectCountryScreen

class MainActivity : ComponentActivity() {

    private val screenViewModel by viewModels<ScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            AuthorizationScreen()
            SelectCountryScreen(
                country = screenViewModel.countries,
                id = screenViewModel.country,
                onClick = {screenViewModel.changeCountry(it)}
            )
        }
    }
}
