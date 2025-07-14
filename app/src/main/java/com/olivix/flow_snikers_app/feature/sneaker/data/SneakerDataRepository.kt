package com.olivix.flow_snikers_app.feature.sneaker.data

import com.olivix.flow_snikers_app.feature.sneaker.data.remote.MockRemoteSneakersDataSource
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import com.olivix.flow_snikers_app.feature.sneaker.domain.SneakerRepository
import org.koin.core.annotation.Single

@Single
class SneakerDataRepository(private val mockData: MockRemoteSneakersDataSource) :
    SneakerRepository {
    override fun getListSneakers(): List<Sneaker> {
        return mockData.getList()
    }

    override fun getSnikerById(id: String): Sneaker? {
        return mockData.getSneakerById(id)
    }
}