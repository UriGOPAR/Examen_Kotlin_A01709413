package com.example.kotlin.examen_a01709413_uri.domain

import com.example.kotlin.examen_a01709413_uri.data.Repository
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData

class ListRequirement {
    private val repository = Repository()
    suspend operator fun invoke(): CovidData? = repository.getList()
}