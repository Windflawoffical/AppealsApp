package com.example.appealsapp.features.feature_user.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequest
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserServiceImpl (
    private val client: HttpClient
) : UserService {
    override suspend fun getUsers(): List<UserResponse> {
        return client.get { url(UserHttpRoutes.GET_USERS) }
    }

    override suspend fun getUserById(id: Int): AppealResponse? {
        return client.get { url(UserHttpRoutes.GET_USER_BY_ID) }
    }

    override suspend fun createAppeal(appealRequest: AppealRequest) {
        return client.post {
            url(UserHttpRoutes.CREATE_APPEAL)
            contentType(ContentType.Application.Json)
            body = appealRequest}
    }

    override suspend fun createUser(userRequest: UserRequest) {
        return client.post {
            url(UserHttpRoutes.CREATE_USER)
            contentType(ContentType.Application.Json)
            body = userRequest}
    }
}