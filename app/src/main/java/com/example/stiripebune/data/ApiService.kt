package com.example.stiripebune.data

import com.example.stiripebune.model.News
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/top-headlines?country=us&apiKey=95d53dd483b4425c927c069230e41e5a/")
    suspend fun getArticles(): List<News>
}