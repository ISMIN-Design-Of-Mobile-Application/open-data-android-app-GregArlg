package com.ismin.opendataapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private lateinit var mMap: GoogleMap
    private var listener: OnMapInteractionListener? = null

    private var stations: ArrayList<Station> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_map, container, false)

        stations = arguments!!.getSerializable(STATIONS_ARGUMENTS_KEY) as ArrayList<Station>

        return rootview
    }

    override fun onStart() {
        super.onStart()
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onMapInteraction(uri)
    }
    */

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        if (context is OnMapInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnMapInteractionListener")
        }

         */
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnMapInteractionListener {
        /*
        // TODO: Update argument type and name
        fun onMapInteraction(uri: Uri)
        */
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnInfoWindowClickListener(this)

        for(stat in stations){
            val positionS = LatLng(stat.latitude.toDouble(), stat.longitude.toDouble())
            mMap.addMarker(MarkerOptions()
                .position(positionS)
                .title("${stat.nom}")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pompe_android2)))
                .tag = stat


        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(48.8534, 2.3488), 5f))
    }
    override fun onInfoWindowClick(p0: Marker?) {
        val intent = Intent(context, DetailsStationActivity::class.java)
        if(p0?.tag != null) {
            intent.putExtra(EXTRA_DETAILS, p0?.tag as Station)
            this.startActivity(intent)
        }
    }

}
