package com.example.kotlin.examen_a01709413_uri.framework.adapter


import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.databinding.ItemBinding
import com.example.kotlin.examen_a01709413_uri.framework.adapter.viewHolders.viewHolder


class Adapter(private val context: Context) : RecyclerView.Adapter<viewHolder>() {
    private var data: List<CovidData> = listOf()


    fun setData(newData: List<CovidData>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val apiObject = data[position]

        val lastEntry = apiObject.cases.entries.lastOrNull()
        lastEntry?.let {
            holder.bind(it, context)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}