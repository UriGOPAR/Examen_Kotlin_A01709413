package com.example.kotlin.examen_a01709413_uri.framework.adapter.viewHolders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen_a01709413_uri.R
import com.example.kotlin.examen_a01709413_uri.data.network.model.CaseDetails
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.databinding.ItemBinding


class viewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(covidCase: Map.Entry<String, CaseDetails>, context: Context) {
        binding.dateTextView.text = covidCase.key

        // Suponiendo que tienes un layout con dos TextViews para total y nuevos casos

    }
}