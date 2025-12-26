package com.example.localrestapi.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localrestapi.modeldata.DataSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import com.example.localrestapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

sealed interface StatusUIDetail {
    data class Success(val satuSiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa:
RepositoryDataSiswa): ViewModel() {

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading // [cite: 248]
            statusUIDetail = try {
                StatusUIDetail.Success(satuSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)) //
            }
            catch (e: IOException){
                StatusUIDetail.Error
            }
            catch (e: HttpException){
                StatusUIDetail.Error
            }
        }
    }
    @SuppressLint("SuspiciousIndentation")
    suspend fun hapusSatuSiswa() {
        try {
            val resp: retrofit2.Response<Void> = repositoryDataSiswa.hapusSatuSiswa(idSiswa)

            if (resp.isSuccessful) {
                println("Sukses Hapus Data: ${resp.message()}")
            } else {
                println("Gagal Hapus Data: ${resp.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            println("Error Jaringan: ${e.message}")
        }
    }
}

