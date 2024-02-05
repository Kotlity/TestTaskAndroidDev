package com.testtask.androiddev.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.testtask.androiddev.R
import com.testtask.androiddev.utils.Constants._18sp

@Composable
fun NumberInfoDescriptionSection(
    modifier: Modifier = Modifier,
    numberInfo: String
) {
    
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen._10dp),
            Alignment.CenterVertically
        )
    ) {
        NumberFromNumberInfo(numberInfo = numberInfo)
        Text(
            text = numberInfo.substringNumberFromString(),
            style = MaterialTheme.typography.displayMedium.copy(
                fontSize = _18sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W500,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
            ),
            textAlign = TextAlign.Center
        )
    }
}

private fun String.substringNumberFromString() = substringAfter(" ").trim()