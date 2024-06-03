package com.example.appealsapp.features.feature_user.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRequestCreateAppeal (
    @SerialName("id")
    val id: Long
)