package com.testtask.androiddev.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.testtask.androiddev.R
import com.testtask.androiddev.domain.model.NumberFact

@Composable
fun NumberFactItem(
    numberFact: NumberFact,
    padding: Dp = dimensionResource(id = R.dimen._5dp),
    onNumberFactClick: (String) -> Unit
) {
    Text(
        modifier = Modifier
            .padding(padding)
            .clickable {
                onNumberFactClick(numberFact.fact)
            },
        text = numberFact.fact,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}