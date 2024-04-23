package com.example.emiratesauctionjb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var carID: Int,
    var titleEn: String,
    var titleAr: String,
    var imageUrl: String,
    var bid: Int,
    var endTimeInSeconds: Int,
    var currencyEn: String,
    var currencyAr: String,
    var currentPrrice: Int,
    var priority: Int
)

fun getFakeCars(): List<Car>{
    return listOf<Car>(
        Car(0, 100, "Chevy", "1200","3",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(1, 100, "Chevy1", "1300","38",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(2, 100, "Chevy2", "1400","356",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(3, 100, "Chevy3", "1500","334",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(4, 100, "Chevy4", "1600","354",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(5, 100, "Chevy5", "1700","356",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(6, 100, "Chevy6", "1800","367",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(7, 100, "Chevy7", "1900","399",7,9876543,"hcey1","suffsfuv", 12100, 3),
        Car(8, 100, "Chevy8", "12000","300",7,9876543,"hcey1","suffsfuv", 12100, 3),

    );
    //return emptyList()
}
