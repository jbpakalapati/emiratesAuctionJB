package com.example.emiratesauctionjb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emiratesauctionjb.Car
import com.example.emiratesauctionjb.MainApplication
import com.example.emiratesauctionjb.data.carsjson
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class CarViewModel : ViewModel() {

    val cardao = MainApplication.emiratesDB.getCarDao()

    val carsLists : LiveData<List<Car>> = cardao.getAllCars()

    fun getData() : LiveData<List<Car>>{
        return cardao.getAllCars()
    }


    fun addCar(item : Int){
        val newCar = Car(carID = 101,
            titleEn = "Mahindrra Scrpio 2017",
            titleAr = "araic text",
            imageUrl = "https://placehold.co/150x130/png?text={$item}",
            bid = 5,
            endTimeInSeconds = 142653,
            currencyAr = "Aed",
            currencyEn = "AED",
            currentPrrice = 12000,
            priority = 1000
        )
        viewModelScope.launch (Dispatchers.IO){
            cardao.addCar(newCar)
        }

    }

    fun deleteCar(){

    }

    fun getCarsFromJson() : List<carsjson> {
        val filePath = "app/src/main/res/cars.json" // Replace with your JSON file path
        val file = File(filePath)

        val jsonString = file.readText()
        val carFromjson = Gson().fromJson(jsonString, carsjson::class.java)
        println("Cars from json "+carFromjson.toString())
        return listOf(carFromjson)
    }
}