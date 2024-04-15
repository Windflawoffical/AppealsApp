package com.example.appealsapp.features.feature_user.data.remote

object UserHttpRoutes {

    private const val BASE_URL = "http://localhost:8080/users"
    const val GET_USER_BY_ID = "$BASE_URL/{id}"
    const val GET_USERS = "$BASE_URL/get_all"
    const val CREATE_APPEAL = "$BASE_URL/create_appeal"
    const val CREATE_USER = "$BASE_URL/create"


}
