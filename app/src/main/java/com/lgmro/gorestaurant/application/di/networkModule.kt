package com.lgmro.gorestaurant.application.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.lgmro.gorestaurant.presentation.utils.network.ConnectivityService
import com.lgmro.gorestaurant.presentation.utils.network.ConnectivityServiceImpl
import org.koin.dsl.module

val retrofitModule = module {

}

val serviceModule = module {

}

val infrastructure = module {
    single { get<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager }
    single<ConnectivityService> { ConnectivityServiceImpl(get()) }
}