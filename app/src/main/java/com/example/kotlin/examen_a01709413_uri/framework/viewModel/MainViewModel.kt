package com.example.kotlin.examen_a01709413_uri.framework.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examen_a01709413_uri.domain.ListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val liveData = MutableLiveData<Object>()
    private val listRequirement = ListRequirement()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: Object? = listRequirement()
            CoroutineScope(Dispatchers.Main).launch {
                liveData.postValue(result!!)
            }
        }}
}