package com.example.kotlin.examen_a01709413_uri.framework.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen_a01709413_uri.data.network.model.Object
import com.example.kotlin.examen_a01709413_uri.databinding.ItemBinding
import com.example.kotlin.examen_a01709413_uri.framework.adapter.viewHolders.viewHolder

class Adapter: RecyclerView.Adapter<viewHolder>() {
    var data:ArrayList<Object> = ArrayList()
    lateinit var context: Context

    fun Adapter(basicData: List<Object>, context: Context){
        this.data = basicData as ArrayList<Object>
        this.context = context
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}