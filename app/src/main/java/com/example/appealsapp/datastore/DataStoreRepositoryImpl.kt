package com.example.appealsapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "DATASTORE_FOR_USER_ID")

class DataStoreRepositoryImpl @Inject constructor(private val context: Context): DataStoreRepository {

    override suspend fun saveUserId(key: String, value: Long) {
        val preferenceKey = longPreferencesKey(key)
        context.dataStore.edit {
                it[preferenceKey] = value
        }
    }

    override suspend fun getUserId(key: String): Long? {
        return  try {
            val preferenceKey = longPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKey]
        }catch (e:Exception) {
            e.printStackTrace()
            null
        }
    }

}

