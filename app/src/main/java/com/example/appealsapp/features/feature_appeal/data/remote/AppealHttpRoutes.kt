package com.example.appealsapp.features.feature_appeal.data.remote

object AppealHttpRoutes {

    private const val BASE_URL = "http://192.168.1.67:8081/appeals"
    const val GET_APPEAL_BY_ID = "$BASE_URL/{id}"
    const val GET_APPEALS = "$BASE_URL/get_all"
    const val CREATE_APPEAL = "$BASE_URL/create"
    const val UPDATE_APPEAL_BY_ID = "$BASE_URL/{id}"

}