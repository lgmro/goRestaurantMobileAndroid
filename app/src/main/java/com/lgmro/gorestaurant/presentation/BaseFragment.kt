package com.lgmro.gorestaurant.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lgmro.gorestaurant.presentation.utils.events.EventTrigger
import org.koin.android.ext.android.inject

abstract class BaseFragment : Fragment() {
    private val eventTrigger: EventTrigger by inject()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        subscribeEvents()
    }

    open fun onEvent(event: Any) {}

    private fun subscribeEvents() {
        lifecycleScope.launchWhenStarted {
            eventTrigger.sendEventFlow.collect { event ->
                onEvent(event)
            }
        }
    }
}