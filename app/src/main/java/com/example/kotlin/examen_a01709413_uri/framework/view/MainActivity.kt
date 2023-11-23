package com.example.kotlin.examen_a01709413_uri.framework.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.databinding.MainActivityBinding
import com.example.kotlin.examen_a01709413_uri.framework.adapter.Adapter
import com.example.kotlin.examen_a01709413_uri.framework.viewModel.MainViewModel

class MainActivity: AppCompatActivity()  {
    private lateinit var binding: MainActivityBinding
    private val adapter : Adapter = Adapter()
    private lateinit var data:ArrayList<CovidData>
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        viewModel.getList()
    }

    private fun initializeBinding() {
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList: List<CovidData>) {
        binding.recyclerview.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayoutManager

    }

}