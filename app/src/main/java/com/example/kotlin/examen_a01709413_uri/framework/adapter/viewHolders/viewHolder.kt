package com.example.kotlin.examen_a01709413_uri.framework.adapter.viewHolders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.databinding.ItemBinding

class viewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CovidData, context: Context){
        binding.Name.text = item.country

    }

}