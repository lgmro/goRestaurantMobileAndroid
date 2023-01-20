package com.lgmro.gorestaurant.application.App

import android.app.Application
import com.lgmro.gorestaurant.application.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                retrofitModule,
                serviceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}