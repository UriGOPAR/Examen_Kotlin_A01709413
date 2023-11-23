package com.example.kotlin.examen_a01709413_uri.data

import android.util.Log
import com.example.kotlin.examen_a01709413_uri.data.network.ApiClient
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData

class Repository {
    private val api = ApiClient()
    suspend fun getList(): CovidData? {
    Log.d("Repository", "getList() iniciado")

    try {
        // Suponiendo que hay una llamada a una API o base de datos aquí
        val data = api.getList()
            Log.d("Repository", "Datos recibidos: $data")

        return data
    } catch (e: Exception) {
        Log.e("Repository", "Error en getList(): ${e.message}")
        return null
    }
}
}
