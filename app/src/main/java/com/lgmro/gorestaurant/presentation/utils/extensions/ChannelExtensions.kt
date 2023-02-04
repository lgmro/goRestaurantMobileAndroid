package com.lgmro.gorestaurant.presentation.utils

import kotlinx.coroutines.channels.Channel

suspend fun <T> Channel<T>.triggerSendEvent(value: T) {
    this.send(value)
}