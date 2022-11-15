package com.example.retrofit.network

import com.example.retrofit.model.NewsDTO
import com.example.retrofit.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("v2/top-headlines")
    fun getAllNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "8844b0834bdd4512b4b60843855392aa"
    ): Call<NewsDTO>
}

// 8844b0834bdd4512b4b60843855392aa MY API KEY