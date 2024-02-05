package com.testtask.androiddev.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.testtask.androiddev.R
import com.testtask.androiddev.presentation.composables.NumberFactButton
import com.testtask.androiddev.presentation.composables.NumberInfoDescriptionSection
import com.testtask.androiddev.utils.Constants._1f

@Composable
fun DescriptionScreen(
    navHostController: NavHostController,
    numberInfo: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen._20dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NumberInfoDescriptionSection(
            modifier = Modifier
                .weight(_1f)
                .fillMaxWidth(),
            numberInfo = numberInfo
        )
        NumberFactButton(
            modifier = Modifier.fillMaxWidth(),
            onButtonClick = {
                navHostController.popBackStack()
            },
            text = stringResource(id = R.string.goBack)
        )
    }
}