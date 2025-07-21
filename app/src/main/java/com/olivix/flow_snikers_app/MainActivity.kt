package com.olivix.flow_snikers_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ahora sí lanzamos la escritura
        lifecycleScope.launch(Dispatchers.IO) {
            //saveMockSneakersToFirestore()
        }
    }
/*
DEFINED TO SAVE THE MOCK lIST TO FIRESTORE

    private suspend fun saveMockSneakersToFirestore() {
        val fs = Firebase.firestore
        val mockList = MockRemoteSneakersDataSource().getList()

        mockList.forEach { sneaker ->
            val entity = sneaker.toEntity()
            val docId = sneaker.styleID.takeIf { it.isNotBlank() }
                ?: fs.collection("sneakers").document().id

            try {
                fs.collection("sneakers")
                    .document(docId)
                    .set(entity)
                    .await()
                Log.d("Firestore", "✅ Guardada ${sneaker.shoeName} como ID=$docId")
            } catch (e: Exception) {
                Log.e("Firestore", "❌ Error guardando ${sneaker.shoeName}", e)
            }
        }

        // Para verificar, leemos de vuelta
        val all = fs.collection("sneakers").get().await()
        Log.d("Firestore", "Documentos en sneakers: ${all.documents.map { it.id }}")
    }

 */
}
