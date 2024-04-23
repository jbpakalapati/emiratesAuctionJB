package com.example.emiratesauctionjb.data

data class carsjson(
    var carID : Int,
    var image : String,
    var titleEn : String,
    var titleAr : String,
    var auctionInfo : List<carrAuctionInfo>
)
