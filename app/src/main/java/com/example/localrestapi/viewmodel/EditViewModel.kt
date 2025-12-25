package com.example.localrestapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.localrestapi.modeldata.UIStateSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.localrestapi.modeldata.DetailSiswa
import com.example.localrestapi.modeldata.toDataSiswa
import com.example.localrestapi.modeldata.toUiStateSiswa
import com.example.localrestapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.Response


class EditViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa:
  RepositoryDataSiswa): ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
  private set

  private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
  init {
    viewModelScope.launch {
      uiStateSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
        .toUiStateSiswa()
    }
  }
  fun updatedUiState(detailSiswa: DetailSiswa) {
    uiStateSiswa =
      UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
  }
  private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean {
    return with(uiState){
      nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
    }
  }
  suspend fun editSatuSiswa(){
    if (validasiInput(uiStateSiswa.detailSiswa)){
      val call: Response <Void> = repositoryDataSiswa.editSatuSiswa(idSiswa, uiStateSiswa
        .detailSiswa.toDataSiswa())

      if (call.isSuccessful){
        println("Update Sukses: ${call.message()}")

      }
    }
  }
  }