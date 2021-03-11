package com.example.stiripebune.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.stiripebune.Resource
import com.example.stiripebune.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(private val mNewsRepository: NewsRepository) : ViewModel(){

    fun getNews() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(mNewsRepository.getNews()))
        }catch (ex: Exception){
            emit(Resource.error(null,ex.message ?: "Error Fetching Data"))
        }
    }

}