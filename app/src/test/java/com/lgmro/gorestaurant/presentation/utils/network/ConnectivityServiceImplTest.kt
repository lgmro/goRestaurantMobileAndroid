package com.lgmro.gorestaurant.presentation.utils.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ConnectivityServiceImplTest {
    @RelaxedMockK
    private lateinit var connectivityManager: ConnectivityManager

    private lateinit var connectivityService: ConnectivityService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        connectivityService = ConnectivityServiceImpl(connectivityManager)
    }

    @Test
    fun `when network is available should return status available`() = runTest {
        // Arrange
        mockNetworkAvailable(true)

        //Act
        val result = connectivityService.isConnected().first()

        //Assert
        assertEquals(StatusNetwork.Available, result)
    }

    @Test
    fun `when network is unavailable should return status unavailable`() = runTest {
        // Arrange
        mockNetworkAvailable(false)

        //Act
        val result = connectivityService.isConnected().first()

        //Assert
        assertEquals(StatusNetwork.Unavailable, result)
    }

    @Test
    fun `when network capabilities is null should return status unavailable`() = runTest {
        // Arrange
        every {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        } returns null

        //Act
        val result = connectivityService.isConnected().first()

        //Assert
        assertEquals(StatusNetwork.Unavailable, result)
    }

    private fun mockNetworkAvailable(state: Boolean?) {
        every {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_INTERNET
            )
        } returns state
    }
}