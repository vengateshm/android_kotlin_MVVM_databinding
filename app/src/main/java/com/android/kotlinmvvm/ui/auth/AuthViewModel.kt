package com.android.kotlinmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.android.kotlinmvvm.data.repositories.UserRepository
import com.android.kotlinmvvm.utils.Coroutines

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


        Coroutines.main {
            // Bad practice, tight coupling
            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                // Success
                authStateListener?.onSuccess(response.body()?.user!!)
            } else {
                authStateListener?.onFailure("Error code: ${response.code()}")
            }
        }
    }
}