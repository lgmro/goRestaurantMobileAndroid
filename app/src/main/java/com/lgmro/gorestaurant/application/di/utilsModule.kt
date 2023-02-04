package com.lgmro.gorestaurant.application.di

import com.lgmro.gorestaurant.presentation.utils.events.EventTrigger
import com.lgmro.gorestaurant.presentation.utils.events.EventTriggerImpl
import org.koin.dsl.module

val utilsModule = module {
    single<EventTrigger> { EventTriggerImpl() }
}