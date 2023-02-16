package com.lgmro.gorestaurant.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.lgmro.gorestaurant.R
import com.lgmro.gorestaurant.databinding.FragmentLoginBinding
import com.lgmro.gorestaurant.presentation.BaseFragment
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment() {
    private val viewModel: LoginViewModel by inject()
    private lateinit var binding: FragmentLoginBinding
    override fun onEvent(event: Any) {
        when (event) {
            is LoginEvent.NavigateToSignUpScreen -> Snackbar.make(
                binding.root,
                "Screen Login Sign UP",
                Snackbar.LENGTH_LONG
            ).show()
            is LoginEvent.ShowPopUpNetworkUnavailable -> Snackbar.make(
                binding.root,
                "Network unavailable",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        ).apply {
            viewModel = this@LoginFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            this@LoginFragment.eventTrigger = this@LoginFragment.viewModel
        }
        return binding.root
    }
}