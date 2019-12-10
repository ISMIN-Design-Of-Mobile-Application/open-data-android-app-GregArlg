package com.ismin.opendataapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.stationsservicemapfr.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var stationTest: Station

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
        stationTest = Station(43.3f, 5.4f, 11111, "TestPump", "La pompe test")

    }


    /**
     * Fct d'appel du fragment en paramètre
     */
    private fun putFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.a_main_rootview, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }



}
