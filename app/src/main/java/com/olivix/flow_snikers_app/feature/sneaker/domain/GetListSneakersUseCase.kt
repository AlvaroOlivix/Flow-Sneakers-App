package com.olivix.flow_snikers_app.feature.sneaker.domain

import org.koin.core.annotation.Single


@Single
class GetListSneakersUseCase(private val sneakerRepository: SneakerRepository) {
    operator fun invoke(): List<Sneaker> {
        return sneakerRepository.getListSneakers()
    }
}