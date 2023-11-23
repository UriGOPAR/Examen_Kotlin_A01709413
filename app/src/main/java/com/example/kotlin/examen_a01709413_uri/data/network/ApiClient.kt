package com.example.kotlin.examen_a01709413_uri.data.network

import NetworkModuleID
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData


class ApiClient {
    private lateinit var api: ApiService

    suspend fun getList(): CovidData? {
        api = NetworkModuleID()
        return try {
            api.getList()

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}