package com.ismin.opendataapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Station (
    val latitude: Float,
    val longitude: Float,
    @SerializedName("id")
    val identifiant: Int,
    @SerializedName("brand")
    val marque: String,
    @SerializedName("name")
    val nom: String,
    var image: Int
): Serializable{
    @PrimaryKey(autoGenerate = true)
    var ident: Int = 0
}
