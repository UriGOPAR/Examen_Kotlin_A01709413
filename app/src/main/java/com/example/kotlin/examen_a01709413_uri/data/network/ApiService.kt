package com.example.kotlin.examen_a01709413_uri.data.network

import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("covid19?country=mexico")
    suspend fun getList(@Header("Authorization") token: String): Object
}