package com.example.appealsapp.datastore

interface DataStoreRepository {

    suspend fun saveUserId(key: String, value: Long)

    suspend fun getUserId(key: String): Long?

}