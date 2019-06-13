package com.android.kotlinmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.kotlinmvvm.R
import com.android.kotlinmvvm.utils.hide
import com.android.kotlinmvvm.utils.show
import com.android.kotlinmvvm.utils.showToast
import kotlinx.android.synthetic.main.activity_login.*

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
//        showToast("Login started")
        progressBar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progressBar.hide()
            showToast(it)
        })
    }

    override fun onFailure(message: String) {
        progressBar.hide()
        showToast(message)
    }
}
