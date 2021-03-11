package com.example.stiripebune.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stiripebune.data.ApiHelper
import com.example.stiripebune.repository.NewsRepository
import java.lang.IllegalArgumentException

class ViewModelFactory (private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NewsViewModel::class.java)){
            return NewsViewModel(NewsRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}