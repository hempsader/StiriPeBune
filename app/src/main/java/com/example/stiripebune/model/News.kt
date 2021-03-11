package com.example.stiripebune.model

import com.google.gson.annotations.SerializedName
import java.util.*

//  https://newsapi.org/v2/top-headlines?country=us&apiKey=95d53dd483b4425c927c069230e41e5a -Api Key

data class News(
     val id: Long,
    @SerializedName("title")
     val title: String,
    @SerializedName("url")
     val url: String,
    @SerializedName("urlToImage")
     val urlToImage: String,
    @SerializedName("publishedAt")
     val date: Date)

data class NewsList(
    @SerializedName("articles")
      val articles: List<News>
)