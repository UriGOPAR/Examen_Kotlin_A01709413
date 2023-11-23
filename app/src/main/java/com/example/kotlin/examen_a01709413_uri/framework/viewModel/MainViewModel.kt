package com.example.kotlin.examen_a01709413_uri.framework.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.domain.ListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val liveData = MutableLiveData<CovidData?>()
    private val listRequirement = ListRequirement()

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result: CovidData? = listRequirement()
            if (result != null) {
                CoroutineScope(Dispatchers.Main).launch {
                    liveData.postValue(result)
                }
            } else {
                // Manejar el caso en que result es nulo, por ejemplo, mostrar un mensaje de error
                Log.e("MainViewModel", "Result is null")
            }
        }
    }
}