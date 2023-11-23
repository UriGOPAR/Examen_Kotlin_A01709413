package com.example.kotlin.examen_a01709413_uri.data.network

import com.example.kotlin.examen_a01709413_uri.utils.Constants

class ApiClient {
    private lateinit var api: ApiService

    suspend fun getList(): Object? {
        api = NetworkModuleDI()
        return try {
            api.getList("Bearer ${Constants.TOKEN}")

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}