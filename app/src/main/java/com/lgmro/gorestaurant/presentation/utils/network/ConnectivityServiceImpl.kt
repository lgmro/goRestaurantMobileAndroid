package com.lgmro.gorestaurant.presentation.utils.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConnectivityServiceImpl(private val connectivityManager: ConnectivityManager) :
    ConnectivityService {
    override fun isConnected(): Flow<StatusNetwork> {
        val connected =  connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
        return flow {
            if (connected) {
                emit(StatusNetwork.Available)
            } else {
                emit(StatusNetwork.Unavailable)
            }
        }
    }

}