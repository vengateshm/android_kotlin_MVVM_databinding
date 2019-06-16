package com.android.kotlinmvvm.ui.auth

import androidx.lifecycle.LiveData
import com.android.kotlinmvvm.data.db.entities.User

interface AuthStateListener {
    fun onStarted()
    //    fun onSuccess(loginResponse: LiveData<String>)
    fun onSuccess(user: User)

    fun onFailure(message: String)
}