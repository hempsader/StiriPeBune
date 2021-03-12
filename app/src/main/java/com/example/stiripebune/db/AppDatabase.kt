package com.example.stiripebune.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.stiripebune.model.News
import java.lang.IllegalStateException

@Database(entities = [News::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun newsDao(): NewsDao

    companion object{
        @Volatile private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun instantiate(context:Context){
            synchronized(LOCK){
                if(INSTANCE == null){
                  INSTANCE =   Room.databaseBuilder(context, AppDatabase::class.java, "news.db").build()
                }
            }
        }
        fun get(): AppDatabase? {
            if(INSTANCE == null) throw IllegalStateException("DB NOT INSTANTIATED")
            return INSTANCE
        }
    }
}