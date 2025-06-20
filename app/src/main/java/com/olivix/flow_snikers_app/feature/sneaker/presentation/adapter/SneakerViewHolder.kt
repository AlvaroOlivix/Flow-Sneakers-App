package com.olivix.flow_snikers_app.feature.sneaker.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.olivix.flow_snikers_app.databinding.ItemSneakerBinding
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker

class SneakerViewHolder(private val binding: ItemSneakerBinding) : ViewHolder(binding.root) {
    fun bindData(sneaker: Sneaker) {
        binding.apply {
            tvSneakerName.text = sneaker.shoeName
            //tvPrice.text = sneaker.brand
        }
    }
}