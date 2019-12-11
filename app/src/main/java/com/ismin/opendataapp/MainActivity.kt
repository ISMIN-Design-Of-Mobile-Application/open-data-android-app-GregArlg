package com.ismin.opendataapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.stationsservicemapfr.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var stationTest1: Station
    private lateinit var stationTest2: Station

    private var stationList: ArrayList<Station> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fragment affiché à l'ouverture
        putFragment(StationListFragment())


        // Boutons

        //Appelle le fragment List au clic sur le bouton map
        listeBtn.setOnClickListener { putFragment(StationListFragment())  }

        //Appelle le fragment Map au clic sur le bouton map
        carteBtn.setOnClickListener { putFragment(MapFragment())  }

        //Appelle le fragment Info au clic sur le bouton info
        infoBtn.setOnClickListener { putFragment(InfoFragment())  }


        //Station test à Marseille
        stationTest1 = Station(43.3f, 5.4f, 11111, "TestPump", "La pompe test", R.drawable.ic_gas_pump)
        //Station test à Bordeaux
        stationTest2 = Station(44.8333f, -0.5667f, 22222, "TestPump2", "La 2e pompe test", R.drawable.ic_gas_pump)

        stationList.add(stationTest1)
        stationList.add(stationTest2)

    }


    /**
     * Fct d'appel du fragment en paramètre
     */
    private fun putFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        //if (fragment == StationListFragment()) {
            val bundle = Bundle()
            bundle.putSerializable(STATIONS_ARGUMENTS_KEY, stationList)
            fragment.arguments = bundle
        //}

        fragmentTransaction.replace(R.id.a_main_rootview, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }



}
