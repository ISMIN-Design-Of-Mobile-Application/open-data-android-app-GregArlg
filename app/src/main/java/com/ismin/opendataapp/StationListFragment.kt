package com.ismin.opendataapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class StationListFragment : Fragment() {
    private var listener: OnStationListListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_station_list, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*   if (context is OnInfoClicListener) {
               listener = context
           } else {
               throw RuntimeException(context.toString() + " must implement OnInfoClicListener")
           }
           */
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnStationListListener {
        // TODO: Update argument type and name
        // fun onInfoClic(uri: Uri)
    }
}
