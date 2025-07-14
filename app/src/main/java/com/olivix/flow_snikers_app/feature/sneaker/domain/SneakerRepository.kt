package com.olivix.flow_snikers_app.feature.sneaker.domain

interface SneakerRepository {

    suspend fun getListSneakers():List<Sneaker>
    suspend fun getSnikerById(id:String):Sneaker?
    suspend fun saveSneaker(sneakers: List<Sneaker>)
}