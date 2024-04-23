package com.example.emiratesauctionjb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emiratesauctionjb.Car
import com.example.emiratesauctionjb.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
}