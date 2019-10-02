package com.example.controlhealt123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class newControlActivity : AppCompatActivity() {

    private lateinit var txtName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var txtDni:EditText
    private lateinit var radioButtonGroup: RadioGroup
    private lateinit var radio :RadioButton
    private lateinit var btnNewControl:Button

    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_control)

        radioButtonGroup = findViewById(R.id.radioGroupGender)

        txtName = findViewById(R.id.eUsername)
        txtEmail = findViewById(R.id.eEmail)
        txtPassword = findViewById(R.id.ePassword)
        txtDni = findViewById(R.id.eDni)
        btnNewControl = findViewById(R.id.btnNewControl)

        progressBar=findViewById(R.id.progressBar)

        //progressBar= ProgressBar(this)
        database= FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference= database.reference.child("User")

        btnNewControl.setOnClickListener{
            createNewControl()

        }


    }



    private fun createNewControl(){

        val name= txtName.text.toString()
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()
        val cedula =  txtDni.text.toString()

        var idRadioGroup = radioButtonGroup.checkedRadioButtonId

        if (idRadioGroup!=-1){
            radio = findViewById(idRadioGroup)
            Toast.makeText(this,"on click ${radio.text}",Toast.LENGTH_LONG).show()
        }

        else
        {
            Toast.makeText(this,"on click no selected",Toast.LENGTH_LONG).show()
        }


        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(cedula)){

            progressBar.visibility= View.VISIBLE



            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        val user:FirebaseUser? = auth.currentUser
                        verifyEmail(user)

                        val userBD = dbReference.child(user!!.uid)
                        userBD.child("Name").setValue(name)
                        userBD.child("Cedula").setValue(cedula)
                     //   userBD.child("Gender").setValue(radio.text.toString())
                        action()
                        //behavoir
                        finish()

                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this,loginActivity::class.java))
    }

    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if (task.isComplete){

                    Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"Error en los datos, email no enviado",Toast.LENGTH_LONG).show()
                }
            }
    }



}
