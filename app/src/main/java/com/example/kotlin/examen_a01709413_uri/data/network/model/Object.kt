package com.example.kotlin.examen_a01709413_uri.data.network.model

data class Object (
    val country: String,
    val region: String,
    val case:  Map<String, Incidentes>
)