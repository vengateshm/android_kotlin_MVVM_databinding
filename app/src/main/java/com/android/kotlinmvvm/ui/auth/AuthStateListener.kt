package com.android.kotlinmvvm.ui.auth

import androidx.lifecycle.LiveData

interface AuthStateListener {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message: String)
}