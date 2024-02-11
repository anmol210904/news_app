package com.example.newsapp.models

data class news(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)