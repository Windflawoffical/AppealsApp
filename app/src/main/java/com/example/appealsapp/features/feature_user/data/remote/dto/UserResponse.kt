package com.example.appealsapp.features.feature_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val sex: String,
    val phoneNumber: String,
    val password: String
)
