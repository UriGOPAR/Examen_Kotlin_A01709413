package com.example.kotlin.examen_a01709413_uri.data

import com.example.kotlin.examen_a01709413_uri.data.network.ApiClient

class Repository {
    private val api = ApiClient()
    suspend fun getList(): Object? = api.getList()
}