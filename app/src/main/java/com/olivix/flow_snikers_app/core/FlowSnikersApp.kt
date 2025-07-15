package com.olivix.flow_snikers_app.core

import android.app.Application
import com.google.firebase.FirebaseApp
import com.olivix.flow_snikers_app.feature.sneaker.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class FlowSnikersApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        startKoin {
            androidContext(this@FlowSnikersApp)
            modules(AppModule().module)
        }
    }
}