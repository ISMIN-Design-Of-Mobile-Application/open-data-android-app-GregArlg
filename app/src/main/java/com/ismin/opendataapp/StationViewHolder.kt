package com.ismin.opendataapp

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StationViewHolder (rootView: View, showDetails:(Int) -> Unit) : RecyclerView.ViewHolder(rootView) {
    var txvStationNom: TextView
    var txvStationId: TextView
    var imvImage: ImageView
    var btnDetail: Button

    init {
        this.txvStationNom = rootView.findViewById(R.id.text_nom)
        this.txvStationId = rootView.findViewById(R.id.text_id)
        this.imvImage = rootView.findViewById(R.id.pump_image)
        this.btnDetail = rootView.findViewById(R.id.detailBtn)
        btnDetail.setOnClickListener{
            showDetails(adapterPosition)
        }

    }
}