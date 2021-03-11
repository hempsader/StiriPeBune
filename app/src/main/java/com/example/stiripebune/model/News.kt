package com.example.stiripebune.model

import com.google.gson.annotations.SerializedName
import java.util.*

//  https://newsapi.org/v2/top-headlines?country=us&apiKey=95d53dd483b4425c927c069230e41e5a -Api Key

data class News(
    private val id: Long,
    @SerializedName("title")
    private val title: String,
    @SerializedName("url")
    private val url: String,
    @SerializedName("urlToImage")
    private val urlToImage: String,
    @SerializedName("publishedAt")
    private val date: Date)