package com.example.stiripebune.views

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.stiripebune.db.AppDatabase
import com.example.stiripebune.model.News
import com.example.stiripebune.repository.NewsRepository
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class NewsMediator (private val repository: NewsRepository):RemoteMediator<Int, News>(){
    override suspend fun load(loadType: LoadType, state: PagingState<Int, News>): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    lastItem.id
                }
            }
            val newsRepo = repository.getNews().body()?.articles ?: emptyList()

            AppDatabase.get()?.withTransaction {
                if(loadType == LoadType.REFRESH){
                    AppDatabase.get()?.newsDao()?.clearAll()
                }
                AppDatabase.get()?.newsDao()?.insertAll(repository.getNews().body()?.articles ?: emptyList())
            }
            MediatorResult.Success(endOfPaginationReached = )
        }catch (e: IOException){
            MediatorResult.Error(e)
        }catch (e: HttpException)
    }

}