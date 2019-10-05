package com.example.controlhealt123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class loginActivity : AppCompatActivity() {

    private lateinit var txtUser : EditText
    private lateinit var txtPassword : EditText
    private lateinit var  auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val  btn_submit= findViewById<Button>(R.id.btn_submitLogin)
        val  btn_newControl = findViewById<Button>(R.id.btn_NewControlLogin)

        txtPassword= findViewById(R.id.ePasswordLogin)
        txtUser = findViewById(R.id.eUsernameLogin)
        auth = FirebaseAuth.getInstance()




        btn_submit.setOnClickListener{
            loginStart()
        }

        btn_newControl.setOnClickListener {
            startActivity(Intent(this,newControlActivity::class.java))
        }
    }

    fun loginStart(){

        val email= txtUser.text.toString()
        val password= txtPassword.text.toString()


        if (!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)){
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {task ->

                    if (task.isSuccessful){
                        action()
                    }
                    else
                    {
                        Toast.makeText(this,"Authentication Failed..",Toast.LENGTH_LONG).show()
                    }

                }


        }

    }

    private fun action(){
        startActivity(Intent(this,bottomNavActivity::class.java))
    }
}
