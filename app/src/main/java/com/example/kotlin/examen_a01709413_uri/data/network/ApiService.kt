package com.example.kotlin.examen_a01709413_uri.data.network

import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("covid19")
    suspend fun getCovid(
        @Header("X-Api-Key") api: String,
        @Query("country") country: String
    ): List<CovidData>
}