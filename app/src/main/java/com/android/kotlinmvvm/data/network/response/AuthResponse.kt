package com.android.kotlinmvvm.data.network.response

import com.android.kotlinmvvm.data.db.entities.User

// Data class must have atleast one primary constructor
// val - only getter
// var - both getter and setter
data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)