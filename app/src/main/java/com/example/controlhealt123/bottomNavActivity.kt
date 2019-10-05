package com.example.controlhealt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView


class bottomNavActivity : AppCompatActivity(),comunicator {

    var userData : MutableList<UserData> = ArrayList()

    override fun changeData(name: String, etapa: String) {

    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                val mainFragment = mainFragmentActivity()
                val bundle = Bundle()
                bundle.putParcelableArrayList("send",ArrayList<UserData>(userData))
                mainFragment.arguments=bundle

                transaction.replace(R.id.contenedor,mainFragment).commit()

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {

                val clinicalDiagnosis = clinicalDiagnosisFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("send", ArrayList<UserData>(userData))
                clinicalDiagnosis.arguments = bundle

                transaction.replace(R.id.contenedor,clinicalDiagnosis).commit()

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                val NutritionFragment = NutritionFragment()
                /*val bundle = Bundle()
                bundle.putParcelableArrayList("send", ArrayList<UserData>(userData))
                NutritionFragment.arguments = bundle*/
                transaction.replace(R.id.contenedor,NutritionFragment).commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val mainFragent = mainFragmentActivity()


        transaction.replace(R.id.contenedor,mainFragent).commit()
    }

    override  fun addDataUser(Age:String,Tall:String,Weigth:String,Albumina:String){
        var userData = UserData( Age,Tall,Weigth,Albumina)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragmentAddNotify = mainFragmentActivity()
        val bundle = Bundle()


        fragmentAddNotify.arguments = bundle
        transaction.replace(R.id.contenedor,fragmentAddNotify).commit()
    }

}
