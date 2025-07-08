package com.olivix.flow_snikers_app.feature.sneaker.domain

import android.util.Log
import org.koin.core.annotation.Single


@Single
class GetListSneakersUseCase(private val sneakerRepository: SneakerRepository) {
    suspend operator fun invoke(): List<Sneaker> {

        val list= sneakerRepository.getListSneakers()
        Log.d("@dev", "Sneakers count: ${list.size}")
        return list
    }
}