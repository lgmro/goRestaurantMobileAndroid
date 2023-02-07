package com.lgmro.gorestaurant.presentation.utils.events

import com.lgmro.gorestaurant.presentation.utils.extensions.triggerSendEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class EventTriggerImpl : EventTrigger {
    private val sendEventChannel: Channel<Any> = Channel()
    override val sendEventFlow = sendEventChannel.receiveAsFlow()

    override suspend fun sendEvent(event: Any) {
        sendEventChannel.triggerSendEvent(event)
    }
}