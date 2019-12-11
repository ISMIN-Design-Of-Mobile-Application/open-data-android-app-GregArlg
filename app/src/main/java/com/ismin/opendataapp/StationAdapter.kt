package com.ismin.opendataapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StationAdapter(private val stations: ArrayList<Station>) :
    RecyclerView.Adapter<StationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_station, parent,
            false)

        return StationViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: StationViewHolder, position: Int) {
        val (latitude, longitude, identifiant, marque, nom, image) = this.stations[position]

        viewholder.txvStationLat.text = latitude.toString()
        viewholder.txvStationLong.text = longitude.toString()
        viewholder.txvStationId.text = identifiant.toString()
        viewholder.txvStationMarque.text = marque
        viewholder.txvStationNom.text = nom
        viewholder.imvImage.setImageResource(image)
    }


    override fun getItemCount(): Int {
        return this.stations.size
    }
}