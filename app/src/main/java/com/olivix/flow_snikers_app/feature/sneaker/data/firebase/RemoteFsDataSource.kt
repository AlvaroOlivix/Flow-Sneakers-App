package com.olivix.flow_snikers_app.feature.sneaker.data.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import kotlinx.coroutines.tasks.await
import org.koin.core.annotation.Single

@Single
class FirestoreRemoteDataSource(
    private val firestore: FirebaseFirestore
) {
    private val collection = firestore.collection("sneakers")

    suspend fun getAllSneakers(): List<Sneaker> {
        val snapshot = collection.get().await()
        return snapshot.documents.mapNotNull { document ->
            document.toObject(FbSneakerEntity::class.java)?.toDomain()
        }
    }

    suspend fun addSneaker(sneaker: Sneaker): String {
        val entity = sneaker.toEntity()
        val ref = collection.add(entity).await()
        return ref.id
    }

    suspend fun appendSneakers(sneakers: List<Sneaker>) {
        if (sneakers.isEmpty()) return
        sneakers.forEach { sneaker ->
            val entity = sneaker.toEntity()
            collection.add(entity).await()
        }
    }


    suspend fun getSneakerById(id: String): Sneaker? {
        val document = collection.document(id).get().await()
        return document.toObject(FbSneakerEntity::class.java)?.toDomain()
    }


    suspend fun saveSneakers(sneakers: List<Sneaker>) {
        if (sneakers.isEmpty()) return
        sneakers.forEach { sneaker ->
            val entity = sneaker.toEntity()
            collection.document(sneaker.styleID)
                .set(entity)
                .await()
        }
    }

    /**
     * Updates an existing sneaker document.
     */
    suspend fun updateSneaker(id: String, sneaker: FbSneakerEntity) {
        require(id.isNotBlank()) { "Sneaker ID must not be blank" }
        collection.document(id).set(sneaker).await()
    }

    /**
     * Deletes a sneaker by ID.
     */
    suspend fun deleteSneaker(id: String) {
        collection.document(id).delete().await()
    }
}

