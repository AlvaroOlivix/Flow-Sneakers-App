package com.olivix.flow_snikers_app.feature.sneaker.data

import com.olivix.flow_snikers_app.feature.sneaker.data.firebase.FirestoreRemoteDataSource
import com.olivix.flow_snikers_app.feature.sneaker.data.remote.MockRemoteSneakersDataSource
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import com.olivix.flow_snikers_app.feature.sneaker.domain.SneakerRepository
import org.koin.core.annotation.Single

@Single
class SneakerDataRepository(
    private val mockData: MockRemoteSneakersDataSource,
    private val remoteData: FirestoreRemoteDataSource
) :
    SneakerRepository {
    override suspend fun getListSneakers(): List<Sneaker> {
        val localData = mockData.getList()
        if (localData.isNotEmpty()) {
            val sneakersM = remoteData.getAllSneakers()
            remoteData.saveSneakers(sneakersM)
            return sneakersM
        }
        return localData
    }

    override suspend fun getSnikerById(id: String): Sneaker? {
        return remoteData.getSneakerById(id)
    }

    override suspend fun saveSneaker(sneakers: List<Sneaker>) {
        return remoteData.saveSneakers(sneakers)
    }
}