package com.example.appealsapp.features.feature_appeal.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface AppealService {

    suspend fun getAppeals(): List<AppealResponse>

    suspend fun getAppealById(id: Int): AppealResponse?

    suspend fun createAppeal(appealRequest: AppealRequest)

    suspend fun updateAppeal(id: Int, appealRequest: AppealRequest)

    companion object {
        fun create(): AppealService {
            return AppealServiceImpl(
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