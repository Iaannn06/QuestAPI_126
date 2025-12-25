package com.example.localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.localrestapi.modeldata.DataSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import com.example.localrestapi.uicontroller.route.DestinasiDetail

sealed interface StatusUIDetail {
    data class Success(val satuSiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa:
RepositoryDataSiswa): ViewModel() {

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
}

