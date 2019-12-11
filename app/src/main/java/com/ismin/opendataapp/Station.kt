package com.ismin.opendataapp

import java.io.Serializable

data class Station (
    val latitude: Float,
    val longitude: Float,
    val identifiant: Int,
    val marque: String,
    val nom: String,
    val image: Int
): Serializable
