package com.example.stiripebune.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.stiripebune.model.News

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<News>)

    @Query("select * from newsTable")
    fun pagingSource(): PagingSource<Int,News>

    @Query("delete from newsTable")
    suspend fun clearAll()
}