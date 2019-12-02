package com.example.stationsservicemapfr

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismin.opendataapp.R


class InfoFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnInfoClicListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onInfoClic(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnInfoClicListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnInfoClicListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnInfoClicListener {
        // TODO: Update argument type and name
        fun onInfoClic(uri: Uri)
    }


}
