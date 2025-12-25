package com.example.localrestapi.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.localrestapi.viewmodel.EditViewModel
import com.example.localrestapi.viewmodel.provider.PenyediaViewModel
import com.example.localrestapi.viewmodel.provider.PenyediaViewModel.Factory
import kotlinx.coroutines.channels.Channel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
navigateBack: () -> Unit,
onNavigateUp: () -> Unit,
modifier: Modifier = Modifier,
viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}