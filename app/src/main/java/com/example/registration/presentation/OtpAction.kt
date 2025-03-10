package com.example.registration.presentation

sealed interface OtpAction {
    data class OnEnterNumber(val number: Int?, val index: Int, val goEnd:() ->Unit): OtpAction
    data class OnChangeFieldFocused(val index: Int): OtpAction
    data object OnKeyboardBack: OtpAction
}