package com.olivix.flow_snikers_app.feature.sneaker.di

import com.olivix.flow_snikers_app.feature.sneaker.data.SneakerDataRepository
import com.olivix.flow_snikers_app.feature.sneaker.data.remote.MockRemoteSneakersDataSource
import com.olivix.flow_snikers_app.feature.sneaker.domain.SneakerRepository
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.olivix.flow_snikers_app")
class AppModule {
    @Single
    fun mockSopurce():MockRemoteSneakersDataSource{
        return MockRemoteSneakersDataSource()
    }
    @Single
    fun provideRepository(
        source: MockRemoteSneakersDataSource
    ): SneakerRepository {
        return SneakerDataRepository(source)
    }
}