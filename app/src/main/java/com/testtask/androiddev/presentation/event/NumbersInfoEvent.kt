package com.testtask.androiddev.presentation.event

sealed class NumbersInfoEvent {

    data class OnNumberInput(val numberInput: String): NumbersInfoEvent()
    data object OnNumberInfo: NumbersInfoEvent()
    data object OnRandomNumberInfo: NumbersInfoEvent()
    data object OnSearchHistoryUpdate: NumbersInfoEvent()
    data class OnNavigate(val numberInfo: String): NumbersInfoEvent()
}