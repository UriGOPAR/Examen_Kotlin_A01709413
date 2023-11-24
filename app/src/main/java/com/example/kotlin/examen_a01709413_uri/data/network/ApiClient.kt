package com.example.kotlin.examen_a01709413_uri.data.network

import NetworkModuleID
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.utils.Constants


class ApiClient {
    private val api: ApiService = NetworkModuleID()

    suspend fun getCovid(country: String): List<CovidData>? {
        return try {
            api.getCovid(api = Constants.API, country = country)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}