package com.example.kotlin.examen_a01709413_uri.framework.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen_a01709413_uri.R
import com.example.kotlin.examen_a01709413_uri.data.Repository
import com.example.kotlin.examen_a01709413_uri.data.network.ApiClient

import com.example.kotlin.examen_a01709413_uri.databinding.MainActivityBinding
import com.example.kotlin.examen_a01709413_uri.framework.adapter.Adapter
import com.example.kotlin.examen_a01709413_uri.framework.viewModel.MainViewModel
import com.example.kotlin.examen_a01709413_uri.framework.viewModel.viewModelFactory

class MainActivity: AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private val apiRepository = Repository(ApiClient())
    private val viewModel: MainViewModel by viewModels { viewModelFactory(apiRepository) }
    private val adapter: Adapter by lazy { Adapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        initializeObservers()
        viewModel.getCovid("mexico")
    }

    private fun setUpRecyclerView() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun initializeObservers() {
        viewModel.covidData.observe(this) { apiObjects ->
            apiObjects?.let {
                adapter.setData(it)
            }
        }
    }
}
