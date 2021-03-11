package com.example.stiripebune.views

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.stiripebune.R
import com.example.stiripebune.Status
import com.example.stiripebune.data.ApiHelper
import com.example.stiripebune.data.ApiService
import com.example.stiripebune.data.RetrofitBuilder
import com.example.stiripebune.viewmodel.NewsViewModel
import com.example.stiripebune.viewmodel.ViewModelFactory
import java.io.Console

class NewsListFragment: Fragment(R.layout.news_recycler_fragment) {
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupModel()
    }

    private fun setupModel(){
        newsViewModel = ViewModelProviders.of(this,ViewModelFactory(ApiHelper(RetrofitBuilder.newsService))).get(NewsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.getNews().observe(viewLifecycleOwner    , Observer {
            it?.let { it ->
                when(it.status){
                    Status.SUCCESS -> {
                        it.data?.let {it2 ->
                            Log.d("aa", it2.toString())
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
}