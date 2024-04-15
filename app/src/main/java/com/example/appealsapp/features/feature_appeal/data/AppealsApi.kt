package com.example.appealsapp.features.feature_appeal.data

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AppealsApi {

    @GET("/appeals/{id}")
    suspend fun getAppealById(id: Int): Appeal?

    @GET("/appeals/get_all")
    fun getAppeals(id: Int): Flow<List<Appeal>>

    @POST("/appeals/create")
    suspend fun createAppeal(appeal: Appeal)

    @PUT("/appeals/{id}")
    suspend fun updateAppeal(id: Int, appeal: Appeal)

    companion object {
        const val BASE_URL = "http://localhost:8081"
    }
}