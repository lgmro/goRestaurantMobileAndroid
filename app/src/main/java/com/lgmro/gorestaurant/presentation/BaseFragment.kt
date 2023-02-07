package com.lgmro.gorestaurant.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lgmro.gorestaurant.presentation.utils.events.EventTrigger

abstract class BaseFragment : Fragment() {
    var eventTrigger: EventTrigger? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        subscribeEvents()
    }

    open fun onEvent(event: Any) {}

    private fun subscribeEvents() {
        lifecycleScope.launchWhenStarted {
            eventTrigger?.sendEventFlow.let {
                it?.collect { event ->
                    onEvent(event)
                }
            }
        }
    }
}