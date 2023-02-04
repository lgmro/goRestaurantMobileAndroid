package com.lgmro.gorestaurant.presentation.login

sealed class LoginEvent {
    object NavigateToSignUpScreen : LoginEvent()
}
