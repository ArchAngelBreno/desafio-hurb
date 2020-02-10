package com.desafiohurb.data.hotel.entity


import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeaturedItem(
    @Json(name = "amenities")
    val amenities: List<String>? = null,
    @Json(name = "description")
//    @ColumnInfo(name = "featureItem_description")
    val description: String? = null,
    @Json(name = "image")
//    @ColumnInfo(name = "featureItem_image")
    val image: String? = null,
    @Json(name = "name")
//    @ColumnInfo(name = "featureItem_name")
    val name: String? = null
)