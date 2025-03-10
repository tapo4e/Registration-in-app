package com.example.registration.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.R
import com.example.registration.data.Country
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScreenViewModel() : ViewModel() {
    val countries = listOf(
        Country("Belarus", "+375", R.drawable.belarus_flag,Regex("\\d{9}"),9),
        Country("Russia", "+7", R.drawable.russian_flag,Regex("\\d{10}"),10),
        Country("USA", "+1", R.drawable.american_flag,Regex("\\d{10}"),10))
    var country by mutableIntStateOf(0)
    private set

    var isResend by mutableStateOf(false)
    private var timeLeft by mutableIntStateOf(30)

    fun timer(){
        viewModelScope.launch {
            isResend = true
            while(timeLeft>0 && isResend) {
                delay(1000)
                timeLeft -= 1
            }
            isResend = false
            timeLeft = 30
        }
    }
    fun changeCountry(id: Int){
        country = id
    }
    fun getTime(): String {
        val remainingSeconds = timeLeft % 60
        return String.format("%02d", remainingSeconds)
    }

}