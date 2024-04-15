package com.example.appealsapp.di

import com.example.appealsapp.features.feature_appeal.data.AppealsApi
import com.example.appealsapp.features.feature_user.data.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppealsApi(): AppealsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AppealsApi.BASE_URL)
            .build()
            .create(AppealsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersApi(): UsersApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UsersApi.BASE_URL)
            .build()
            .create(UsersApi::class.java)
    }

}