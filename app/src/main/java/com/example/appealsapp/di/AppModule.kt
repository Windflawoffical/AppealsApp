package com.example.appealsapp.di

import android.content.Context
import com.example.appealsapp.datastore.DataStoreRepository
import com.example.appealsapp.datastore.DataStoreRepositoryImpl
import com.example.appealsapp.features.feature_appeal.data.remote.AppealService
import com.example.appealsapp.features.feature_appeal.data.remote.AppealServiceImpl
import com.example.appealsapp.features.feature_user.data.remote.UserService
import com.example.appealsapp.features.feature_user.data.remote.UserServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.WebSockets
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging)
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15000
            }
        }
    }
    @Provides
    @Singleton
    fun provideAppealService(client: HttpClient): AppealService {
        return AppealServiceImpl(client)
    }
    @Provides
    @Singleton
    fun provideUserService(client: HttpClient): UserService {
        return UserServiceImpl(client)
    }

    @Provides
    @Singleton
    fun providesDatastoreRepo (@ApplicationContext context: Context): DataStoreRepository = DataStoreRepositoryImpl(context)
}