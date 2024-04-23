package com.example.emiratesauctionjb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.emiratesauctionjb.Car

@Database(entities = [Car::class], version = 1)
abstract class EmiratesDB : RoomDatabase(){
    companion object{
        const val NAME = "EmiratesDB"
    }

    abstract fun getCarDao() : CarDao
}