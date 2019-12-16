package com.ismin.opendataapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Station::class], version = 2)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getStationDao(): StationDAO

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getAppDatabase(context: MainActivity): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                            AppDataBase::class.java,
                            "db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as AppDataBase
        }
    }
}
