package com.example.stiripebune.views

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stiripebune.R
import com.example.stiripebune.Status
import com.example.stiripebune.data.ApiHelper
import com.example.stiripebune.data.ApiService
import com.example.stiripebune.data.RetrofitBuilder
import com.example.stiripebune.model.News
import com.example.stiripebune.viewmodel.NewsViewModel
import com.example.stiripebune.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.news_recycler_fragment.*
import java.io.Console

class NewsListFragment: Fragment(R.layout.news_recycler_fragment) {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsRecicler
    private lateinit var newsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun setup(view: View){
        newsViewModel = ViewModelProviders.of(this,ViewModelFactory(ApiHelper(RetrofitBuilder.newsService))).get(NewsViewModel::class.java)
        newsRecycler = view.findViewById(R.id.newsRecycler)
        newsRecycler.layoutManager = LinearLayoutManager(this.requireContext())
        newsAdapter = NewsRecicler(arrayListOf())
        newsRecycler.adapter = newsAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_recycler_fragment,container,false)
        setup(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.getNews().observe(viewLifecycleOwner    , Observer {
            it?.let { it ->
                when(it.status){
                    Status.SUCCESS -> {
                        it.data?.let {it2 ->
                            //setupList(it.data)
                            Log.d("aa", it2.body()?.articles.toString())
                        }
                    }
                    Status.ERROR -> {
                        Log.d("aa", it.message.toString())
                    }
                    Status.LOADING -> {
                        Log.d("aa","vvv")
                    }
                    else -> {
                        Log.d("aa", "SAdasd")
                    }
                }
            }
        })
    }
    private fun setupList(news: List<News>){
        newsAdapter.apply {
            this.addNews(news)
            notifyDataSetChanged()
        }
    }
}