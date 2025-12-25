package com.example.localrestapi.viewmodel

import com.example.localrestapi.modeldata.DataSiswa

sealed interface StatusUIDetail {
    data class Success(val satuSiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

