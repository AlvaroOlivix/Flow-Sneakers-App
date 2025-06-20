package com.olivix.flow_snikers_app.feature.sneaker.domain

data class Sneaker(
    val styleID: String,
    val shoeName: String,
    val brand: String?,
    val thumbnail: String?,
    val imageLinks: List<String>?,
    val colorway: String?,
    val description: String?,
    val releaseDate: String?
)
