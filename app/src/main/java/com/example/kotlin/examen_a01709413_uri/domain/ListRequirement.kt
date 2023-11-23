package com.example.kotlin.examen_a01709413_uri.domain

import com.example.kotlin.examen_a01709413_uri.data.Repository

class ListRequirement {
    private val repository = Repository()
    suspend operator fun invoke(): Object? = repository.getList()
}