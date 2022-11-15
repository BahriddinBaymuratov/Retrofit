package com.example.retrofit.model

data class NewsDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int,
)
