package com.example.stiripebune.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

//  https://newsapi.org/v2/top-headlines?country=us&apiKey=95d53dd483b4425c927c069230e41e5a -Api Key


@Entity(tableName = "newsTable")
data class News(
    @PrimaryKey(autoGenerate = true)
     val id: Long,
    @SerializedName("title")
     val title: String,
    @SerializedName("url")
     val url: String,
    @SerializedName("urlToImage")
     val urlToImage: String,
    @SerializedName("publishedAt")
     val date: String)


data class NewsList(
    @SerializedName("articles")
      val articles: List<News>
)