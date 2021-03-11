package com.example.stiripebune.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitBuilder {
    private const val BASE_URL = "https://newsapi.org/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsService = getRetrofit().create(ApiService::class.java)
}