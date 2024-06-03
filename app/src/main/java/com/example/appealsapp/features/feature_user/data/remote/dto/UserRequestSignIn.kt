package com.example.appealsapp.features.feature_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserRequestSignIn (
    val email: String,
    val password: String
)