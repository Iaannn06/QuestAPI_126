package com.example.localrestapi.repositori

import com.example.localrestapi.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa (): List<DataSiswa>

}