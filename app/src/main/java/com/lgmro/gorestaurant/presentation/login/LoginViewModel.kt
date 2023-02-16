package com.lgmro.gorestaurant.presentation.login

import androidx.lifecycle.viewModelScope
import com.lgmro.gorestaurant.presentation.BaseViewModel
import com.lgmro.gorestaurant.presentation.utils.network.ConnectivityService
import com.lgmro.gorestaurant.presentation.utils.network.StatusNetwork
import kotlinx.coroutines.launch

class LoginViewModel(
    private val connectivityObserver: ConnectivityService
): BaseViewModel( ){
    fun onSignInButtonClicked() {
        viewModelScope.launch {
            checkNetworkStatus()
        }
    }

    private suspend fun checkNetworkStatus() {
        connectivityObserver.isConnected().collect { status ->
            when(status) {
                StatusNetwork.Available -> sendEvent(LoginEvent.NavigateToSignUpScreen)
                StatusNetwork.Unavailable -> sendEvent(LoginEvent.ShowPopUpNetworkUnavailable)
            }
        }
    }
}