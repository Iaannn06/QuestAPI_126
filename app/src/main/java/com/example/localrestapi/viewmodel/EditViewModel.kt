package com.example.localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localrestapi.modeldata.DetailSiswa
import com.example.localrestapi.modeldata.UIStateSiswa
import com.example.localrestapi.modeldata.toDataSiswa
import com.example.localrestapi.modeldata.toUiStateSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import com.example.localrestapi.uicontroller.route.DestinasiEdit
import kotlinx.coroutines.launch

class EditViewModel(
  savedStateHandle: SavedStateHandle,
  private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

  var uiStateSiswa by mutableStateOf(UIStateSiswa())
    private set

  private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEdit.itemIdArg])

  init {
    viewModelScope.launch {
      try {
        uiStateSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
          .toUiStateSiswa(true)
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }

  fun updateUiState(detailSiswa: DetailSiswa) {
    uiStateSiswa = UIStateSiswa(
      detailSiswa = detailSiswa,
      isEntryValid = validasiInput(detailSiswa)
    )
  }

  private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
    return with(uiState) {
      nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
    }
  }

  // Pastikan bagian ini di dalam class EditViewModel
  suspend fun editSatuSiswa() {
    if (validasiInput(uiStateSiswa.detailSiswa)) {
      try {
        // PERBAIKAN: Pastikan memanggil repository dengan ID dan Body yang benar
        val call = repositoryDataSiswa.editSatuSiswa(
          idSiswa,
          uiStateSiswa.detailSiswa.toDataSiswa()
        )

        if (call.isSuccessful) {
          println("Update Sukses: ${call.message()}")
        } else {
          println("Update Gagal: ${call.errorBody()?.string()}")
        }
      } catch (e: Exception) {
        println("Error Edit: ${e.message}")
      }
    }
  }
}