package com.lgmro.gorestaurant.presentation.login

import com.lgmro.gorestaurant.CoroutineTestRule
import com.lgmro.gorestaurant.presentation.utils.network.ConnectivityService
import com.lgmro.gorestaurant.presentation.utils.network.StatusNetwork
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @MockK
    private lateinit var connectivityService: ConnectivityService

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginViewModel = LoginViewModel(connectivityService)
    }

    @Test
    fun `when click on sign in button and not has network should show pop up`() = runTest {
        // Arrange
        every { connectivityService.isConnected() } returns flowOf(StatusNetwork.Unavailable)

        // Act
        loginViewModel.onSignInButtonClicked()

        // Assert
        val result = loginViewModel.sendEventFlow.first()
        assertEquals(LoginEvent.ShowPopUpNetworkUnavailable, result)
    }

    @Test
    fun `when click on sign in button and has network should call navigate to sign up screen`() = runTest {
        // Arrange
        every { connectivityService.isConnected() } returns flowOf(StatusNetwork.Available)

        // Act
        loginViewModel.onSignInButtonClicked()

        // Assert
        val result = loginViewModel.sendEventFlow.first()
        assertEquals(LoginEvent.NavigateToSignUpScreen, result)
    }
}