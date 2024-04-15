package com.example.appealsapp.features.feature_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest (
    val nickname: String
)