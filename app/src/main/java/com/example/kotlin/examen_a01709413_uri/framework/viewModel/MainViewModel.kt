package com.example.kotlin.examen_a01709413_uri.framework.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examen_a01709413_uri.data.Repository
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val Repository: Repository) : ViewModel() {

    private val _covidData = MutableLiveData<List<CovidData>>()
    val covidData: LiveData<List<CovidData>> = _covidData

    fun getCovid(country: String) {
        viewModelScope.launch {
            val data = Repository.getCovid(country) ?: emptyList()
            _covidData.postValue(data)
        }
    }
}