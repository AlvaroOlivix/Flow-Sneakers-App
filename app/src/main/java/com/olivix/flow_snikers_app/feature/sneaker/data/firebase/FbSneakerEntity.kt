package com.olivix.flow_snikers_app.feature.sneaker.data.firebase

import androidx.room.Entity
import com.google.firebase.firestore.PropertyName

@Entity(tableName = "sneakers")
data class FbSneakerEntity(
    @get:PropertyName("style_id") @set:PropertyName("style_id") var styleID: String = "",
    @get:PropertyName("shoe_name") @set:PropertyName("shoe_name") var shoeName: String = "",
    @get:PropertyName("brand") @set:PropertyName("brand") var brand: String? = null,
    @get:PropertyName("thumbnail") @set:PropertyName("thumbnail") var thumbnail: String? = null,
    @get:PropertyName("image_links") @set:PropertyName("image_links") var imageLinks: List<String>? = null,
    @get:PropertyName("colorway") @set:PropertyName("colorway") var colorway: String? = null,
    @get:PropertyName("description") @set:PropertyName("description") var description: String? = null,
    @get:PropertyName("release_date") @set:PropertyName("release_date") var releaseDate: String? = null
)