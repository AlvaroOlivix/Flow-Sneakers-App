package com.olivix.flow_snikers_app.feature.sneaker.domain

import org.koin.core.annotation.Single

@Single
class GetSneakerUseCase(private val sneakerRepository: SneakerRepository) {
    suspend operator fun invoke(id: String): Sneaker? {
        return sneakerRepository.getSnikerById(id)
    }
}