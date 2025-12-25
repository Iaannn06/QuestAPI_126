package com.example.localrestapi.repositori

import com.example.localrestapi.apiservice.ServiceApiSiswa
import com.example.localrestapi.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa (): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
    suspend fun getSatuSiswa(id:Int) : DataSiswa
    suspend fun editSatuSiswa(id:Int, dataSiswa: DataSiswa):retrofit2.Responsive<Void>
    suspend fun hapusSatuSiswa(id:Int): retrofit2.Responsive<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa
        .getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa):retrofit2
        .Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    override suspend fun getSatuSiswa(Id: Int): DataSiswa = ServiceApiSiswa.getSatuSiswa(id)
    //override suspend fun editSatuSiswa(id: Int, dataSiswa: DataSiswa):retrofit2.Response<Void> = serviceApiSiswa.editSatuSiswa(id, dataSiswa)
    //override suspend fun hapusSatuSiswa(id:Int):retrofit2.Response<Void>=serviceApiSiswa.hapusSatuSiswa(id)

}