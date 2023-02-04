package com.lgmro.gorestaurant.presentation.login

import androidx.lifecycle.viewModelScope
import com.lgmro.gorestaurant.presentation.BaseViewModel
import com.lgmro.gorestaurant.presentation.utils.events.EventTrigger
import kotlinx.coroutines.launch

class LoginViewModel(
    private val eventTrigger: EventTrigger
) : BaseViewModel( ){
    fun onSignInButtonClicked() {
        viewModelScope.launch {
            eventTrigger.sendEvent(LoginEvent.NavigateToSignUpScreen)
        }
    }
}