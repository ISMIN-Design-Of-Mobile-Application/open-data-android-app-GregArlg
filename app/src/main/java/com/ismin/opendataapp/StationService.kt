package com.ismin.opendataapp

import retrofit2.Call
import retrofit2.http.GET

interface StationService {
    @GET("opendatasoft/datasets/prix_des_carburants_stations%40public/exports/json")
    fun getStations(): Call<List<StationServerData>>
}