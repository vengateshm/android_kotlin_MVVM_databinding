package com.android.kotlinmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.android.kotlinmvvm.data.repositories.UserRepository

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authStateListener: AuthStateListener? = null

    fun onLoginBtnClicked(view: View) {
        authStateListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            // Failure
            authStateListener?.onFailure("Invalid email or password")
            return
        }

        // Bad practice, tight coupling
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        // Success
        authStateListener?.onSuccess(loginResponse)
    }
}