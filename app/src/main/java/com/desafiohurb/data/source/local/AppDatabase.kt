//package com.desafiohurb.data.source.local
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.desafiohurb.data.entity.hotel.Result
//
//@Database(entities = [Result::class], version = 1)
//abstract class AppDatabase: RoomDatabase() {
//
//    abstract fun hotelDao(): HotelDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(AppDatabase::class) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "hurb_database")
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}