package com.olivix.flow_snikers_app.feature.sneaker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.olivix.flow_snikers_app.databinding.ItemSneakerBinding
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker

class SneakerAdapter(private val onItemClick: (Sneaker) -> Unit) : ListAdapter<Sneaker, SneakerViewHolder>(SneakerDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakerViewHolder {
        val binding = ItemSneakerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SneakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SneakerViewHolder, position: Int) {
        val sneaker = getItem(position)
        holder.bindData(sneaker, onItemClick)
    }
}