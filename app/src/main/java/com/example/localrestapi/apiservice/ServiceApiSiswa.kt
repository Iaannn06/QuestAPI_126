package com.example.localrestapi.apiservice

import com.example.localrestapi.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.*

interface ServiceApiSiswa {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    @GET("bacaTeman1.php")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    // ServiceApiSiswa.kt
    @PUT("editTM.php")
    suspend fun editSatuSiswa(
        @Query("id") id: Int,
        @Body dataSiswa: DataSiswa
    ): retrofit2.Response<Void>

    @DELETE("deleteTM.php")
    suspend fun hapusSatuSiswa(
        @Query("id") id: Int
    ): retrofit2.Response<Void>
}