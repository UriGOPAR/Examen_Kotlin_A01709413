package com.example.kotlin.examen_a01709413_uri.domain

import com.example.kotlin.examen_a01709413_uri.data.Repository
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import retrofit2.Callback

class ListRequirement(private val Repository: Repository) {
    suspend operator fun invoke(country: String): List<CovidData>? {
        return Repository.getCovid(country)
    }
}