package com.compose.practise.composepractise.di

import com.compose.practise.composepractise.data.ApiService
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

object AppModule {

    @Singleton
    @Provides
    fun createApiClient(): ApiService {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

}