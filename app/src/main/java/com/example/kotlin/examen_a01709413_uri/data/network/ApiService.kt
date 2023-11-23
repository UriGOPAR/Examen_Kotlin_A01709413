package com.example.kotlin.examen_a01709413_uri.data.network

import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import retrofit2.http.GET

interface ApiService {
    @GET("covid19?country=mexico")
    suspend fun getList(): CovidData
}