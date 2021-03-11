package com.example.stiripebune.repository

import com.example.stiripebune.data.ApiHelper

class NewsRepository (private val apiHelper: ApiHelper){
    suspend fun getNews() = apiHelper.getNews()
}