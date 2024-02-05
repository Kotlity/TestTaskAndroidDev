package com.testtask.androiddev.presentation.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.testtask.androiddev.R

@Composable
fun NumberInputTextField(
    modifier: Modifier = Modifier,
    inputValue: String,
    onInputValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = inputValue,
        onValueChange = onInputValueChange,
        placeholder = {
            Text(text = stringResource(id = R.string.inputNumberPlaceHolder))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}