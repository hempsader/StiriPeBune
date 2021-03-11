package com.example.stiripebune.data

import java.util.*

//  https://newsapi.org/v2/top-headlines?country=us&apiKey=95d53dd483b4425c927c069230e41e5a -Api Key

data class News(private val id: Long,private val title: String, private val url: String, private val urlToImage: String, private val date: Date)