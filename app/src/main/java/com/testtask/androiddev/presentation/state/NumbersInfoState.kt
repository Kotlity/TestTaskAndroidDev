package com.testtask.androiddev.presentation.state

import com.testtask.androiddev.domain.model.NumberFact

data class NumbersInfoState(
    val numberInput: String = "",
    val searchNumbersHistory: List<NumberFact> = emptyList()
)