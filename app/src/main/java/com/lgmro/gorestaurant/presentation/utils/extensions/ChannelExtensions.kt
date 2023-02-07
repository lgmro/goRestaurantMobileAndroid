package com.lgmro.gorestaurant.presentation.utils.extensions

import kotlinx.coroutines.channels.Channel

suspend fun <T> Channel<T>.triggerSendEvent(value: T) {
    this.send(value)
}