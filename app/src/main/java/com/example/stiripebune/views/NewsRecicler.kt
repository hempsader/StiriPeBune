package com.example.stiripebune.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stiripebune.R
import com.example.stiripebune.model.News
import com.squareup.picasso.Picasso

class NewsRecicler(private val newsList: ArrayList<News>): RecyclerView.Adapter<NewsRecicler.NewsHolder>(){

    class NewsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var title: TextView
        private var titleImage: ImageView

        init {
            title = itemView.findViewById(R.id.news_short_desc)
            titleImage = itemView.findViewById(R.id.news_image)
        }

        fun setupViews(news: News){
            title.text = news.title
            Picasso.get().load(news.urlToImage).into(titleImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_news_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.setupViews(newsList[position])
    }

    fun addNews(news: List<News>){
      this.newsList.apply {
          clear()
           addAll(news)
        }
    }

}