package com.example.emiratesauctionjb.Views

import android.content.Context
import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.util.getColumnIndex
import coil.compose.rememberAsyncImagePainter
import com.example.emiratesauctionjb.Car
import com.example.emiratesauctionjb.R
import com.example.emiratesauctionjb.getFakeCars
import com.example.emiratesauctionjb.viewmodel.CarViewModel

@Composable
fun CarListPage(viewModel: CarViewModel){
    
    val carList = getFakeCars() //by viewModel.carsLists.observeAsState() //getFakeCars()

    //viewModel.addCar(1024)
    println("Testing "+carList.toString())
    val carsfromd = viewModel.carsLists
    val cas = viewModel.getCarsFromJson()
    println("saved data "+ carsfromd.toString())

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        //carList?.let {
            LazyColumn (
                // modifier = Modifier.clickable { Toast.makeText("clicked", "", Toast.LENGTH_SHORT).show() }
            ){
                this.itemsIndexed(carList){ index:Int, item: Car->
                    CarCard(item = item)
                }
            print(carList.toString())
            }
        println("testing "+ carList.toString())
        //}

    }

}

@Composable
fun CarCard(item : Car){
    ElevatedCard (
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)

    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
            ){
            Box(modifier = Modifier.size(150.dp)){
                Image(
                    painter = rememberAsyncImagePainter("https://placehold.co/150x130/png?text=%7B100%7D"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Icon(
                    Icons.Rounded.Favorite,
                    contentDescription = "fav_icon"
                )
            }

            Column (modifier = Modifier
                //.fillMaxWidth()
                .padding(10.dp),

            ){
                Text(text = "#"+item.carID.toString(),
                fontSize= 15.sp,
                    color = Color.LightGray

                )
                Text(text= item.titleEn.toString(),
                    fontSize= 22.sp,
                    color = Color.Black)
                Text(text = "AED "+item.currentPrrice.toString(),
                    fontSize= 30.sp,
                    color = Color.Red)
            }
            IconButton(onClick = {
               println("clicked on "+item.toString())

            }) {
                Icon(
                    Icons.Rounded.Delete,
                    contentDescription = "del_icon",
                    tint = Color.Black
                )
            }
        }
    }

}