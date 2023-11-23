package com.example.kotlin.examen_a01709413_uri.data.network.model

import com.google.gson.annotations.SerializedName

data class CovidData (
    @SerializedName("country")val country: String,
    //val region: String,
    //val case:  Map<String, Incidentes>
)