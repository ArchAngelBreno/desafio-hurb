package com.desafiohurb.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desafiohurb.data.hotel.entity.Result

@Dao
interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(results: List<Result>)
//
//    @Query("SELECT * FROM result")
//    fun getHotel(): List<Result>

}
