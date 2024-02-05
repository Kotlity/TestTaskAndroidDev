package com.testtask.androiddev.presentation.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.testtask.androiddev.utils.Constants._40sp

@Composable
fun NumberFromNumberInfo(
    numberInfo: String
) {

    Text(
        text = numberInfo.retrieveNumberFromString(),
        style = MaterialTheme.typography.bodyLarge.copy(
            fontSize = _40sp,
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.Center
    )
}

private fun String.retrieveNumberFromString(): String {
    val blankIndex = indexOf(" ")
    return substring(0..blankIndex)
}