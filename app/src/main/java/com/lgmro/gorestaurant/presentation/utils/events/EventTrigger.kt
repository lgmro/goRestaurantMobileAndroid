package com.lgmro.gorestaurant.presentation.utils.events

import kotlinx.coroutines.flow.Flow

interface EventTrigger {
    val sendEventFlow: Flow<Any>

    suspend fun sendEvent(event: Any)
}