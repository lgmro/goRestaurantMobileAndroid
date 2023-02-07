package com.lgmro.gorestaurant.presentation

import androidx.lifecycle.ViewModel
import com.lgmro.gorestaurant.presentation.utils.events.EventTrigger
import com.lgmro.gorestaurant.presentation.utils.extensions.triggerSendEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel : ViewModel(), EventTrigger {
    private val sendEventChannel: Channel<Any> = Channel()
    override val sendEventFlow = sendEventChannel.receiveAsFlow()
    override suspend fun sendEvent(event: Any) {
        sendEventChannel.triggerSendEvent(event)
    }
}