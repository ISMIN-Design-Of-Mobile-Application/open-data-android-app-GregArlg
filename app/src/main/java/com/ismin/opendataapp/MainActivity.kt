package com.ismin.opendataapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.stationsservicemapfr.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

const val SERVER_BASE_URL = "https://data.opendatasoft.com/api/v2/"

class MainActivity : AppCompatActivity() {

    private lateinit var stationTest1: Station
    private lateinit var stationTest2: Station

    private var stationList: ArrayList<Station> = ArrayList()

    private lateinit var stationService: StationService

    private lateinit var stationDao: StationDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("Coucou")

        // Boutons

        //Appelle le fragment List au clic sur le bouton map
        listeBtn.setOnClickListener { putFragment(StationListFragment()) }

        //Appelle le fragment Map au clic sur le bouton map
        carteBtn.setOnClickListener { putFragment(MapFragment()) }

        //Appelle le fragment Info au clic sur le bouton info
        infoBtn.setOnClickListener { putFragment(InfoFragment()) }


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_BASE_URL)
            .build()

        stationService = retrofit.create<StationService>(StationService::class.java)

        stationDao = AppDataBase.getAppDatabase(this)
            .getStationDao()


        getStationsFromServer()


        /*

        //Station test à Marseille
        stationTest1 = Station(43.3f, 5.4f, 11111, "TestPump", "La pompe test", R.drawable.ic_gas_pump)
        //Station test à Bordeaux
        stationTest2 = Station(44.8333f, -0.5667f, 22222, "TestPump2", "La 2e pompe test", R.drawable.ic_gas_pump)

        /*
        stationList.add(stationTest1)
        stationList.add(stationTest2)

         */



        stationDao.insert(stationTest1)
        stationDao.insert(stationTest2)

        stationList.addAll(stationDao.getAll())

        putFragment(StationListFragment())

         */

    }


    /**
     * Fct d'appel du fragment en paramètre
     */
    private fun putFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        //if (fragment.equals(StationListFragment()) ||  fragment.equals(MapFragment())) {
        val bundle = Bundle()
        bundle.putSerializable(STATIONS_ARGUMENTS_KEY, stationList)
        fragment.arguments = bundle
        //}

        fragmentTransaction.replace(R.id.a_main_rootview, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }


    private fun getStationsFromServer() {
        AppDataBase.getAppDatabase(this).clearAllTables()

        stationService.getStations()
            .enqueue(object : Callback<List<StationServerData>> {
                override fun onResponse(
                    call: Call<List<StationServerData>>,
                    response: Response<List<StationServerData>>
                ) {
                    val serverResponse = response.body()

                    if (serverResponse != null) {

                        var i = 0
                        for (stationData in serverResponse) {

                            trieEtInsereStation(stationData)
                        }

                        stationList.clear()
                        stationList.addAll(stationDao.getAll())

                    } else {
                        val toast = Toast.makeText(
                            this@MainActivity,
                            "Réponse du serveur vide",
                            Toast.LENGTH_LONG
                        )
                        toast.show()
                    }

                    //Fragment affiché à l'ouverture
                    putFragment(StationListFragment())
                }

                override fun onFailure(call: Call<List<StationServerData>>, t: Throwable) {
                    val toast = Toast.makeText(
                        this@MainActivity,
                        "Fail to get stations from server, error : $t",
                        Toast.LENGTH_LONG
                    )
                    toast.show()
                }
            })


    }

    fun trieEtInsereStation(statData: StationServerData) {
        if (statData.marque == "Carrefour Market" ||
            statData.marque == "Carrefour Contact" ||
            statData.marque == "Carrefour" ||
            statData.marque == "Carrefour Express"
        ) {

            if (statData.coordonnees != null &&
                statData.identifiant != null &&
                statData.nom != null
            ) {

                stationDao.insert(
                    Station(
                        statData.coordonnees.latitude,
                        statData.coordonnees.longitude,
                        statData.identifiant,
                        statData.marque,
                        statData.nom,
                        0
                    )
                )
            }
        }
    }


}
