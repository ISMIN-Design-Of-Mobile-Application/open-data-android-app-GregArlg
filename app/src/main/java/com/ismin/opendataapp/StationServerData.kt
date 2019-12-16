package com.ismin.opendataapp

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StationServerData (
    @SerializedName("geo_point")
    val coordonnees: GeoPoint,
    @SerializedName("id")
    val identifiant: Int,
    @SerializedName("brand")
    val marque: String,
    @SerializedName("name")
    val nom: String,
    val image: Int
): Serializable

data class GeoPoint(
    @SerializedName("lat")
    val latitude: Float,
    @SerializedName("lon")
    val longitude: Float
)
