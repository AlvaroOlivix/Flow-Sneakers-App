package com.olivix.flow_snikers_app.feature.sneaker.domain

interface SneakerRepository {

    fun getListSneakers():List<Sneaker>
    fun getSnikerById(id:String):Sneaker?
}