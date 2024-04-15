package com.example.appealsapp.features.feature_user.data

import com.example.appealsapp.features.feature_appeal.data.Appeal
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UsersApi {

    @GET("/users/{id}")
    suspend fun getUserById(id: Int): User?

    @GET("/users/get_all")
    fun getUsers(id: Int): Flow<List<User>>

    @POST("/users/create_appeal")
    suspend fun createAppeal(appeal: Appeal)

    companion object {
        const val BASE_URL = "http://localhost:8080"
    }

}