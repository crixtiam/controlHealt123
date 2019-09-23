package com.example.controlhealt123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var txtAge:EditText
    private lateinit var txtTall:EditText
    private lateinit var txtWeigth:EditText
    private lateinit var txtBloodPresure:EditText
    private lateinit var txtSerineCreatinine:EditText
    private lateinit var txtUrineCreatinine:EditText
    private lateinit var txtAlbumin:EditText
    private lateinit var txtGlomerularFiltration:EditText

    private lateinit var btnDiagnosis:Button

    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database=  FirebaseDatabase.getInstance()
        dbReference = database.reference.child("User")
        auth = FirebaseAuth.getInstance()
        var user = auth.currentUser

        txtAge = findViewById(R.id.eAgeMain)
        txtTall = findViewById(R.id.eTallMain)
        txtWeigth  = findViewById(R.id.eWeigthMain)
        txtBloodPresure  = findViewById(R.id.ePressureMain)
        txtSerineCreatinine = findViewById(R.id.eSerineCreatinineMain)
        txtUrineCreatinine =  findViewById(R.id.eUrineCreatinineMain)
        txtAlbumin = findViewById(R.id.eAlbuminMain)
        txtGlomerularFiltration = findViewById(R.id.eGlomerularFiltration)

        btnDiagnosis = findViewById(R.id.btnDiagnostisisMain)


        Log.d("currentUser ",user.toString())

        if (user!=null){

            btnDiagnosis.setOnClickListener{

                var Age = txtAge.text.toString()
                var Tall = txtTall.text.toString()
                var Weigth = txtWeigth.text.toString()
                var bloodPressure = txtBloodPresure.text.toString()
                var serineCreatinine= txtSerineCreatinine.text.toString()
                var urineCreatinine = txtUrineCreatinine.text.toString()
                var Albumin = txtAlbumin.text.toString()
                var glomerularFiltration= txtGlomerularFiltration.text.toString()


                val userBD = dbReference.child(user.uid)

                val personalDataBD = userBD.child("PersonalData")
                personalDataBD.child("Age").setValue(Age)
                personalDataBD.child("Tall").setValue(Tall)
                personalDataBD.child("Weigth").setValue(Weigth)
                personalDataBD.child("bloodPresure").setValue(bloodPressure)
                personalDataBD.child("serineCreatinine").setValue(serineCreatinine)
                personalDataBD.child("urineCreatinine").setValue(urineCreatinine)
                personalDataBD.child("Albumin").setValue(Albumin)
                personalDataBD.child("glomerularFiltration").setValue(glomerularFiltration)

            }

        }
        else
        {
            Toast.makeText(this,"Authentication Failed",Toast.LENGTH_LONG).show()
        }





    }
}
