package com.testtask.androiddev.presentation.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.testtask.androiddev.R
import com.testtask.androiddev.presentation.composables.EmptySearchNumberFactsHistorySection
import com.testtask.androiddev.presentation.composables.NumberFactButton
import com.testtask.androiddev.presentation.composables.NumberFactsLazyColumn
import com.testtask.androiddev.presentation.composables.NumberInputTextField
import com.testtask.androiddev.presentation.event.NavigationEvent
import com.testtask.androiddev.presentation.event.NumbersInfoEvent
import com.testtask.androiddev.presentation.state.NumbersInfoState
import com.testtask.androiddev.utils.Constants._04f
import com.testtask.androiddev.utils.Constants._05f
import com.testtask.androiddev.utils.Constants._08f
import com.testtask.androiddev.utils.NavigationRoutes
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    navHostController: NavHostController,
    numbersInfoState: NumbersInfoState,
    navigationEvent: Flow<NavigationEvent>,
    onNumbersInfoEvent: (NumbersInfoEvent) -> Unit
) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        navigationEvent.flowWithLifecycle(
            lifecycle = lifecycle,
            minActiveState = Lifecycle.State.STARTED
        ).collect { navigationEvent ->
            when(navigationEvent) {
                is NavigationEvent.OnNavigate -> {
                    val descriptionScreenRoute = NavigationRoutes.DescriptionScreenRoute.appendArgument(navigationEvent.numberInfo)
                    navHostController.navigate(descriptionScreenRoute)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(id = R.dimen._20dp),
                vertical = dimensionResource(id = R.dimen._5dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NumberInputTextField(
                modifier = Modifier.fillMaxWidth(_08f),
                inputValue = numbersInfoState.numberInput,
                onInputValueChange = {
                    onNumbersInfoEvent(NumbersInfoEvent.OnNumberInput(it))
                }
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._5dp)))
            NumberFactButton(
                modifier = Modifier.fillMaxWidth(_08f),
                onButtonClick = {
                    onNumbersInfoEvent(NumbersInfoEvent.OnNumberInfo)
                },
                enabled = numbersInfoState.numberInput.isNotBlank(),
                text = stringResource(id = R.string.getFact)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._20dp)))
            NumberFactButton(
                modifier = Modifier.fillMaxWidth(_08f),
                onButtonClick = {
                    onNumbersInfoEvent(NumbersInfoEvent.OnRandomNumberInfo)
                },
                text = stringResource(id = R.string.getFactAboutRandomNumber)
            )
        }
        Crossfade(
            modifier = Modifier
                .fillMaxWidth(_05f)
                .fillMaxHeight(_04f),
            targetState = numbersInfoState.searchNumbersHistory.isEmpty(),
            label = ""
        ) { isSearchHistoryEmpty ->
            when(isSearchHistoryEmpty) {
                true -> {
                    EmptySearchNumberFactsHistorySection(modifier = Modifier.fillMaxSize())
                }
                else -> {
                    NumberFactsLazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        numberFacts = numbersInfoState.searchNumbersHistory,
                        onNumberFactClick = { numberFact ->
                            onNumbersInfoEvent(NumbersInfoEvent.OnNavigate(numberInfo = numberFact))
                        }
                    )
                }
            }
        }
    }
}