package com.ismin.opendataapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StationViewHolder (rootView: View) : RecyclerView.ViewHolder(rootView) {
    var txvStationNom: TextView
    var txvStationId: TextView
    var txvStationMarque: TextView
    var txvStationLat: TextView
    var txvStationLong: TextView
    var imvImage: ImageView

    init {
        this.txvStationNom = rootView.findViewById(R.id.text_nom)
        this.txvStationId = rootView.findViewById(R.id.text_id)
        this.txvStationMarque = rootView.findViewById(R.id.text_marque)
        this.txvStationLat = rootView.findViewById(R.id.text_lat)
        this.txvStationLong = rootView.findViewById(R.id.text_long)
        this.imvImage = rootView.findViewById(R.id.pump_image)

    }
}