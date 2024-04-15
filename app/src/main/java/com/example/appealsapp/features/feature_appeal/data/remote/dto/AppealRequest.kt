package com.example.appealsapp.features.feature_appeal.data.remote.dto

import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequest
import kotlinx.serialization.Serializable

@Serializable
data class AppealRequest(
    val description: String,
    val userRequest: UserRequest
)
