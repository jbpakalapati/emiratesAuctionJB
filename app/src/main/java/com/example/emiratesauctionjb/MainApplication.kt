package com.example.emiratesauctionjb

import android.app.Application
import androidx.room.Room
import com.example.emiratesauctionjb.database.EmiratesDB

class MainApplication : Application() {
    companion object{
        lateinit var emiratesDB : EmiratesDB
    }

    override fun onCreate() {
        super.onCreate()
        emiratesDB = Room.databaseBuilder(
            applicationContext,
            EmiratesDB::class.java,
            EmiratesDB.NAME
        ).build()
    }
}