package com.example.kotlin.examen_a01709413_uri.framework.viewModel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examen_a01709413_uri.data.Repository
import com.example.kotlin.examen_a01709413_uri.databinding.MainActivityBinding
import com.example.kotlin.examen_a01709413_uri.framework.adapter.Adapter

class viewModelFactory(private val apiRepository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(apiRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}