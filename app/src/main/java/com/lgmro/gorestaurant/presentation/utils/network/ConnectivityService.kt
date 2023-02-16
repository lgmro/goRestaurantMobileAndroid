package com.lgmro.gorestaurant.presentation.utils.network

import kotlinx.coroutines.flow.Flow

interface ConnectivityService {
    fun isConnected(): Flow<StatusNetwork>
}