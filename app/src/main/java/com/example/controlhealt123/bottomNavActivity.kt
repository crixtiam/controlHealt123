package com.example.controlhealt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottomNavActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                val mainFragment = mainFragmentActivity()

                transaction.replace(R.id.contenedor,mainFragment).commit()

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {

                val clinicalDiagnosis = clinicalDiagnosisFragment()
                transaction.replace(R.id.contenedor,clinicalDiagnosis).commit()

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {

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
}
