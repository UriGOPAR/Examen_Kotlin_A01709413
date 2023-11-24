package com.example.kotlin.examen_a01709413_uri.data

import NetworkModuleID
import com.example.kotlin.examen_a01709413_uri.data.network.ApiClient

import com.example.kotlin.examen_a01709413_uri.data.network.ApiService
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import retrofit2.Call
import retrofit2.Callback

class Repository(private val apiClient: ApiClient) {

    suspend fun getCovid(country: String): List<CovidData>? {
        return apiClient.getCovid(country)
    }
}
