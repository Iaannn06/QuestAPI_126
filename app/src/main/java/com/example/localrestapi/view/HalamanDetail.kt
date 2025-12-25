package com.example.localrestapi.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api)
@Composable

fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    navigateUp = navigateBack
){
Scaffold(
    topBar = {
        SiswaTopAppBar(
            title = stringResource(DestinasiDetail.titleRes),
            canNavigateBack = true,
            navigateUp = navigateBack
        )
    }
)
}