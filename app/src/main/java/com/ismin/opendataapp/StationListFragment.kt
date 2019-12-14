package com.ismin.opendataapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


const val STATIONS_ARGUMENTS_KEY = "key"
const val EXTRA_DETAILS = "key_to_details_activity"


class StationListFragment : Fragment() {
    private val NUMBER_OF_COLUMNS = 1

    private var stations: ArrayList<Station> = ArrayList()
    private lateinit var rcvStations: RecyclerView
    private lateinit var stationAdapter:StationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_station_list, container, false)

        stations = arguments!!.getSerializable(STATIONS_ARGUMENTS_KEY) as ArrayList<Station>

        rcvStations = rootView.findViewById(R.id.stationList)
        stationAdapter = StationAdapter(stations, ::showDetails)
        rcvStations.adapter = stationAdapter
        rcvStations.layoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)

        // Inflate the layout for this fragment
        return rootView
    }

    private fun showDetails(position: Int){
        val toast = Toast.makeText(context, "Affichage de ${stations[position].nom}", Toast.LENGTH_SHORT)
        toast.show()

        val intent = Intent(context, DetailsStationActivity::class.java).apply {
            putExtra(EXTRA_DETAILS, stations[position])
        }
        startActivity(intent)
    }
}
