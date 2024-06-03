package com.example.appealsapp.features.feature_user.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignIn
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignUp
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.statement.HttpStatement

interface UserService {

    suspend fun getUsers(): List<UserResponse>

    suspend fun getUserById(id: Int): UserResponse?

    suspend fun createAppeal(appealRequest: AppealRequest)

    suspend fun createUser(userRequestSignUp: UserRequestSignUp)
    suspend fun login(userRequestSignIn: UserRequestSignIn): UserResponse?

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