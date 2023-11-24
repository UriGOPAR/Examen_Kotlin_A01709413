package com.example.kotlin.examen_a01709413_uri.framework.adapter.viewHolders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen_a01709413_uri.R
import com.example.kotlin.examen_a01709413_uri.data.network.model.CaseDetails
import com.example.kotlin.examen_a01709413_uri.data.network.model.CovidData
import com.example.kotlin.examen_a01709413_uri.databinding.ItemBinding
import com.example.kotlin.examen_a01709413_uri.framework.view.BarChartView


class viewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(covidCase: Map.Entry<String, CaseDetails>, country: String,region: String, context: Context) {
        binding.country.text = country
        binding.zona.text = region

        binding.total.text = String.format(context.getString(R.string.total_cases_format), covidCase.value.total)
        binding.nuevos.text = String.format(context.getString(R.string.new_cases_format), covidCase.value.new)

        val barChartView = binding.root.findViewById<BarChartView>(R.id.barChart)
        barChartView?.setValues(covidCase.value.total, covidCase.value.new)


    }
}