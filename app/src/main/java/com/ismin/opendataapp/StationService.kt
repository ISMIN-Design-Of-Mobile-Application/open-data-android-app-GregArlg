package com.ismin.opendataapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StationService {
    @GET("search/?dataset=prix_des_carburants_stations%40public")
    fun getStations(@Query("rows") nbRows: Int) : Call<List<Station>>
}