package com.example.appealsapp.features.feature_appeal.data.remote.dto

import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestCreateAppeal
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignUp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppealRequest(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("user")
    val userRequestCreateAppeal: UserRequestCreateAppeal
)
