package com.testtask.androiddev.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.androiddev.domain.model.NumberFact
import com.testtask.androiddev.domain.use_cases.AppUseCases
import com.testtask.androiddev.presentation.event.NavigationEvent
import com.testtask.androiddev.presentation.event.NumbersInfoEvent
import com.testtask.androiddev.presentation.state.NumbersInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumbersInfoViewModel @Inject constructor(private val appUseCases: AppUseCases): ViewModel() {

    var numbersInfoState by mutableStateOf(NumbersInfoState())
        private set

    private val navigationChannel = Channel<NavigationEvent>()
    val navigationFlow = navigationChannel.receiveAsFlow()

    private var numbersFactsJob: Job? = null

    init {
        onEvent(NumbersInfoEvent.OnSearchHistoryUpdate)
    }

    fun onEvent(numbersInfoEvent: NumbersInfoEvent) {
        when(numbersInfoEvent) {
            is NumbersInfoEvent.OnNumberInput -> {
                updateNumberInput(numbersInfoEvent.numberInput)
            }
            NumbersInfoEvent.OnNumberInfo -> {
                onNumberInfo()
            }
            NumbersInfoEvent.OnRandomNumberInfo -> {
                onRandomNumberInfo()
            }
            NumbersInfoEvent.OnSearchHistoryUpdate -> {
                onSearchHistoryUpdate()
            }
            is NumbersInfoEvent.OnNavigate -> {
                onNavigate(numbersInfoEvent.numberInfo)
            }
        }
    }

    private fun updateNumberInput(numberInput: String) {
        numbersInfoState = numbersInfoState.copy(numberInput = numberInput)
    }

    private fun onNumberInfo() {
        viewModelScope.launch {
            val specificNumberInfo = appUseCases.getInfoAboutSpecificNumberUseCase(number = numbersInfoState.numberInput.toInt())
            val numberFact = NumberFact(fact = specificNumberInfo)
            appUseCases.insertNumberFactUseCase(numberFact = numberFact)
            updateNumberInput("")
        }
    }

    private fun onRandomNumberInfo() {
        viewModelScope.launch {
            val randomNumberInfo = appUseCases.getMathInfoAboutRandomNumber()
            val numberFact = NumberFact(fact = randomNumberInfo)
            appUseCases.insertNumberFactUseCase(numberFact = numberFact)
        }
    }

    private fun onSearchHistoryUpdate() {
        numbersFactsJob?.cancel()
        numbersFactsJob = appUseCases.retrieveNumbersFactsUseCase().onEach { numberFacts ->
            numbersInfoState = numbersInfoState.copy(searchNumbersHistory = numberFacts)
        }
            .launchIn(viewModelScope)
    }

    private fun onNavigate(numberInfo: String) {
        viewModelScope.launch {
            navigationChannel.send(NavigationEvent.OnNavigate(numberInfo = numberInfo))
        }
    }
}