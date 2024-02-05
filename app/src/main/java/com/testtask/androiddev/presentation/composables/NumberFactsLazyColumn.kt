package com.testtask.androiddev.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.testtask.androiddev.domain.model.NumberFact

@Composable
fun NumberFactsLazyColumn(
    modifier: Modifier = Modifier,
    numberFacts: List<NumberFact>,
    onNumberFactClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        items(numberFacts) { numberFact ->
            NumberFactItem(
                numberFact = numberFact,
                onNumberFactClick = onNumberFactClick
            )
        }
    }
}