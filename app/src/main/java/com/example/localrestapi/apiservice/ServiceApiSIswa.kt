package com.example.localrestapi.apiservice

import com.example.localrestapi.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET(value="bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST(value="InsertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): retrofit2.Response<Void>
}