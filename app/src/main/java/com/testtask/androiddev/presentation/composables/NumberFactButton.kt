package com.testtask.androiddev.presentation.composables

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NumberFactButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    enabled: Boolean = true,
    text: String
) {

    OutlinedButton(
        modifier = modifier,
        onClick = onButtonClick,
        enabled = enabled
    ) {
        Text(text = text)
    }
}