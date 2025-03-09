package com.example.registration.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.registration.R
import com.example.registration.data.Country

class ScreenViewModel() : ViewModel() {
    val countries = listOf(
        Country("Belarus", "+375", R.drawable.belarus_flag,Regex("\\d{9}"),9),
        Country("Russia", "+7", R.drawable.russian_flag,Regex("\\d{10}"),10),
        Country("USA", "+1", R.drawable.american_flag,Regex("\\d{10}"),10))
    var country by mutableIntStateOf(0)
    private set




    fun changeCountry(id: Int){
        country = id
    }


}