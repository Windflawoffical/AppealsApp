package com.example.appealsapp.features.feature_user.data.remote

import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignIn
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignUp
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.statement.HttpStatement
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserServiceImpl (
    private val client: HttpClient
) : UserService {
    override suspend fun getUsers(): List<UserResponse> {
        return client.get { url(UserHttpRoutes.GET_USERS) }
    }

    override suspend fun getUserById(id: Int): UserResponse? {
        return client.get { url(UserHttpRoutes.GET_USER_BY_ID + id) }
    }

    override suspend fun createAppeal(appealRequest: AppealRequest) {
        return client.post {
            url(UserHttpRoutes.CREATE_APPEAL)
            contentType(ContentType.Application.Json)
            body = appealRequest}
    }

    override suspend fun createUser(userRequestSignUp: UserRequestSignUp) {
        return client.post {
            url(UserHttpRoutes.CREATE_USER)
            contentType(ContentType.Application.Json)
            body = userRequestSignUp}
    }

    override suspend fun login(userRequestSignIn: UserRequestSignIn): UserResponse? {
        return client.post {
            url(UserHttpRoutes.LOGIN)
            contentType(ContentType.Application.Json)
            body = userRequestSignIn
            println(body)}
    }
}