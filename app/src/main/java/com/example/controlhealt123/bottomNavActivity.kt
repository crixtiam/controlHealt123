package com.example.controlhealt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.controlhealt123.Adapters.DiagnosisCardAdapter
import com.example.controlhealt123.DataModel.ModelPersonalData
import com.example.controlhealt123.DataModel.PersonalData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class bottomNavActivity : AppCompatActivity() {


    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var  auth: FirebaseAuth

  //  private var mDiagnosisListAdapter : DiagnosisCardAdapter?=null



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

              //  ModelPersonalData.addObserver(this)
              //  val dataList : ListView = findViewById(R.id.data_list)
        //observar
                //val data : ArrayList<PersonalData> = ArrayList()
            //mDiagnosisListAdapter= DiagnosisCardAdapter(this,R.layout.data_card_item,data)

             // dataList.adapter = mDiagnosisListAdapter

                transaction.replace(R.id.contenedor,clinicalDiagnosis).commit()

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                val NutritionFragment = NutritionFragment()
                transaction.replace(R.id.contenedor,NutritionFragment).commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        database= FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        dbReference= database.getReference()


        var user = auth.currentUser

        /*ModelPersonalData.addObserver(this)
        val dataList : ListView = findViewById(R.id.data_list)
        //observar
        val data : ArrayList<PersonalData> = ArrayList()
            mDiagnosisListAdapter= DiagnosisCardAdapter(this,R.layout.data_card_item,data)

           dataList.adapter = mDiagnosisListAdapter
*/



        ///otraa actividad





        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val mainFragent = mainFragmentActivity()

        transaction.replace(R.id.contenedor,mainFragent).commit()
    }
 /*   override fun update(p0: Observable?, p1: Any?) {
        mDiagnosisListAdapter?.clear()
        val data = ModelPersonalData.getData()
        if (data!=null){
            mDiagnosisListAdapter?.clear()
            mDiagnosisListAdapter?.addAll(data)
            mDiagnosisListAdapter?.notifyDataSetChanged()
        }




    }

    override fun onResume() {
        super.onResume()
        ModelPersonalData.addObserver(this)
    }

    override fun onPause() {
        super.onPause()

        ModelPersonalData.addObserver(this)
    }

    override fun onStop() {
        super.onStop()

        ModelPersonalData.addObserver(this)
    }
*/

}
