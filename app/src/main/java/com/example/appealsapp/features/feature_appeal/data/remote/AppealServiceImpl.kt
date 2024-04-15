package com.example.appealsapp.features.feature_appeal.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class AppealServiceImpl (
    private val client: HttpClient
) : AppealService {


    override suspend fun getAppeals(): List<AppealResponse> {
        return client.get { url(AppealHttpRoutes.GET_APPEALS) }
    }

    override suspend fun getAppealById(id: Int): AppealResponse? {
        return client.get { url(AppealHttpRoutes.GET_APPEAL_BY_ID + id) }
    }

    override suspend fun createAppeal(appealRequest: AppealRequest) {
        return client.post {
            url(AppealHttpRoutes.CREATE_APPEAL)
            contentType(ContentType.Application.Json)
            body = appealRequest}
    }


    override suspend fun updateAppeal(id: Int, appealRequest: AppealRequest) {
        return client.put {
            url(AppealHttpRoutes.UPDATE_APPEAL_BY_ID + id)
            contentType(ContentType.Application.Json)
            body = appealRequest}

    }

}