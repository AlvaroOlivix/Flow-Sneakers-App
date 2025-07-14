package com.olivix.flow_snikers_app.feature.sneaker.di

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.olivix.flow_snikers_app.feature.sneaker.data.SneakerDataRepository
import com.olivix.flow_snikers_app.feature.sneaker.data.firebase.FirestoreRemoteDataSource
import com.olivix.flow_snikers_app.feature.sneaker.data.remote.MockRemoteSneakersDataSource
import com.olivix.flow_snikers_app.feature.sneaker.domain.SneakerRepository
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.olivix.flow_snikers_app")
class AppModule {
    @Single
    fun mockSopurce(): MockRemoteSneakersDataSource {
        return MockRemoteSneakersDataSource()
    }

    @Single
    fun provideRepository(
        source: MockRemoteSneakersDataSource,
        remote: FirestoreRemoteDataSource
    ): SneakerRepository {
        return SneakerDataRepository(
            source, remote
        )
    }

    @Single
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }
}