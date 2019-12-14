package com.ismin.opendataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details_station.*

class DetailsStationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_station)

        val station:Station = intent.getSerializableExtra(EXTRA_DETAILS) as Station

        img_marque.setImageResource(station.image)
        nom_marque.setText(station.marque)
        nom_station.setText(station.nom)
        id_station.setText(station.identifiant.toString())
        lat_station.setText(station.latitude.toString())
        long_station.setText(station.longitude.toString())

    }
}
