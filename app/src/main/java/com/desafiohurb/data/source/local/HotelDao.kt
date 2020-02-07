package com.desafiohurb.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desafiohurb.data.entity.hotel.Result

@Dao
interface HotelDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(results: List<Result>)
//
//    @Query("SELECT * FROM result")
//    fun getHotel(): LiveData<List<Result>>

}
