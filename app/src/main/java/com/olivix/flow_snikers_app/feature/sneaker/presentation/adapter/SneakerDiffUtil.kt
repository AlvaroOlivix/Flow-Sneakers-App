package com.olivix.flow_snikers_app.feature.sneaker.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker

class SneakerDiffUtil : DiffUtil.ItemCallback<Sneaker>() {
    override fun areItemsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem.styleID == newItem.styleID
    }

    override fun areContentsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem == newItem
    }
}