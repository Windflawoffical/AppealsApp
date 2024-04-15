package com.example.appealsapp.features.feature_appeal.data.remote.dto

import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import kotlinx.serialization.Serializable

@Serializable
data class AppealResponse(
    val id: Long,
    val description: String,
    val user: UserResponse,
    val status: String
)



