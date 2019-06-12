package com.android.kotlinmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.android.kotlinmvvm.R
import com.android.kotlinmvvm.utils.showToast

class LoginActivity : AppCompatActivity(), AuthStateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: com.android.kotlinmvvm.databinding.ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.authViewModel = viewModel

        viewModel.authStateListener = this
    }

    override fun onStarted() {
        showToast("Login started")
    }

    override fun onSuccess() {
        showToast("Login success")
    }

    override fun onFailure(message: String) {
        showToast(message)
    }
}
