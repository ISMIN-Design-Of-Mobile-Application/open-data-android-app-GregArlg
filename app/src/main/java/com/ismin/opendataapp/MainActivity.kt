package com.ismin.opendataapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.stationsservicemapfr.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Boutons

        //Appelle le fragment Info au clic sur le bouton info
        infoBtn.setOnClickListener { putInfoFragment()  }
    }


    /**
     * Fct d'appel du fragment InfoFragment
     */
    private fun putInfoFragment(){
        val fragment = InfoFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.a_main_rootview, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
        //infoBtn.visibility = View.GONE
    }

}
