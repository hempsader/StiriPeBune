package com.example.stiripebune

import android.app.Application
import com.example.stiripebune.db.AppDatabase

class GlobalApp : Application(){
    override fun onCreate() {
        super.onCreate()
        AppDatabase.instantiate(this)
    }
}