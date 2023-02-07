package com.lgmro.gorestaurant.presentation.login

import androidx.lifecycle.viewModelScope
import com.lgmro.gorestaurant.presentation.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel: BaseViewModel( ){
    fun onSignInButtonClicked() {
        viewModelScope.launch {
            sendEvent(LoginEvent.NavigateToSignUpScreen)
        }
    }
}