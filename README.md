# emiratesAuctionJB


###Room DataBase 
-------------

###DAO Interface
```javascript
@Dao
interface CarDao {

    @Query("SELECT * FROM Car")
    fun getAllCars() : LiveData<List<Car>>

    @Upsert
    fun addCar(car : Car)

    @Query("Delete FROM CAR WHERE id = :id")
    fun deleteCar(id : Int)
}
```
###DataBase Name
```javascript
@Database(entities = [Car::class], version = 1)
abstract class EmiratesDB : RoomDatabase(){
companion object{
const val NAME = "EmiratesDB"
}

    abstract fun getCarDao() : CarDao
}
```

###ViewModel
```javascript
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
```
#### Loading Sample Data

```javascript
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
```
#### Loading Data from Json file
```javascript
    fun getCarsFromJson() : List<carsjson> {
        val filePath = "app/src/main/res/cars.json" // Replace with your JSON file path
        val file = File(filePath)

        val jsonString = file.readText()
        val carFromjson = Gson().fromJson(jsonString, carsjson::class.java)
        println("Cars from json "+carFromjson.toString())
        return listOf(carFromjson)
    }
```