package com.ismin.opendataapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StationViewHolder (rootView: View) : RecyclerView.ViewHolder(rootView) {
    var txvStationNom: TextView
    var txvStationId: TextView
    var imvImage: ImageView

    init {
        this.txvStationNom = rootView.findViewById(R.id.text_nom)
        this.txvStationId = rootView.findViewById(R.id.text_id)
        this.imvImage = rootView.findViewById(R.id.pump_image)

    }
}