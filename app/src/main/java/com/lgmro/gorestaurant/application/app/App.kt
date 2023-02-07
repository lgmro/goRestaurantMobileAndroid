package com.lgmro.gorestaurant.application.app

import android.app.Application
import com.lgmro.gorestaurant.application.di.repositoryModule
import com.lgmro.gorestaurant.application.di.retrofitModule
import com.lgmro.gorestaurant.application.di.serviceModule
import com.lgmro.gorestaurant.application.di.useCaseModule
import com.lgmro.gorestaurant.application.di.viewModelModule
import com.lgmro.gorestaurant.application.di.utilsModule
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
                viewModelModule,
                utilsModule
            )
        }
    }
}