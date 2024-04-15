package com.example.appealsapp.features.feature_user.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequest
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging

interface UserService {

    suspend fun getUsers(): List<UserResponse>

    suspend fun getUserById(id: Int): AppealResponse?

    suspend fun createAppeal(appealRequest: AppealRequest)

    suspend fun createUser(userRequest: UserRequest)

    companion object {
        fun create(): UserService {
            return UserServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }

}