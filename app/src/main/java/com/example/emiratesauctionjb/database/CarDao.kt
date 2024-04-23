package com.example.emiratesauctionjb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.emiratesauctionjb.Car

@Dao
interface CarDao {

    @Query("SELECT * FROM Car")
    fun getAllCars() : LiveData<List<Car>>

    @Upsert
    fun addCar(car : Car)

    @Query("Delete FROM CAR WHERE id = :id")
    fun deleteCar(id : Int)
}