package com.example.localrestapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.localrestapi.modeldata.UIStateSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class EditViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa:
  RepositoryDataSiswa): ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
  private set
  }