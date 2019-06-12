package com.android.kotlinmvvm.ui.auth

interface AuthStateListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}