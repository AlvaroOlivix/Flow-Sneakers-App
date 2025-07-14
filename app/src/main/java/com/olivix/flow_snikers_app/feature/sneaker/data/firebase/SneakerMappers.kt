package com.olivix.flow_snikers_app.feature.sneaker.data.firebase

import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker

fun Sneaker.toEntity(): FbSneakerEntity = FbSneakerEntity(
    styleID = this.styleID,
    shoeName = this.shoeName,
    brand = this.brand ?: "Null",
    thumbnail = this.thumbnail ?: "Null",
    imageLinks = this.imageLinks ?: listOf("Null"),
    colorway = this.colorway ?: "Null",
    description = this.description ?: "Null",
    releaseDate = this.releaseDate
)

fun FbSneakerEntity.toDomain(): Sneaker = Sneaker(
    styleID = this.styleID,
    shoeName = this.shoeName,
    brand = this.brand,
    thumbnail = this.thumbnail,
    imageLinks = this.imageLinks,
    colorway = this.colorway,
    description = this.description,
    releaseDate = this.releaseDate
)