package com.ismin.opendataapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StationDAO {
    @Query("SELECT * FROM station")
    fun getAll(): List<Station>

    @Insert
    fun insert(vararg station: Station)

    @Delete
    fun delete(station: Station)

}