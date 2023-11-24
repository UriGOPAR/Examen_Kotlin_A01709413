package com.example.kotlin.examen_a01709413_uri.data.network.model


data class CovidData (
    val country: String,
    val region: String,
    val cases: Map<String, CaseDetails>
)

