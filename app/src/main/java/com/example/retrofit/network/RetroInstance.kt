package com.example.retrofit.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroInstance {
    private const val BASE_URL = "https://api.github.com/"
    private const val BASE_URL2 = "https://newsapi.org/"

    fun retroInstance(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiService::class.java)
    }
}