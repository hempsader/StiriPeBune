package com.example.stiripebune.data

class ApiHelper(private val apiService: ApiService){
    suspend fun getNews() = apiService.getArticles()
}