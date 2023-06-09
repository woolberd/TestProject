package com.example.data.remote.apiservice

import com.example.data.remote.dtos.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("films")
    suspend fun fetchApi(
        @Query("fields") fields: String = "",
        @Query("limit") limit: Int = 50
    ): List<ResponseDto>

    @GET("films/{id}")
    suspend fun fetchDetail(
        @Path("id") id: String
    ): ResponseDto
}