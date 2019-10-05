package com.example.controlhealt123


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.gms.common.internal.Objects
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.lang.IllegalArgumentException


class mainFragmentActivity : Fragment() {

    var interfaz : comunicator?  = null

    private lateinit var txtAge: EditText
    private lateinit var txtTall: EditText
    private lateinit var txtWeigth: EditText
    private lateinit var txtBloodPresure: EditText
    private lateinit var txtSerineCreatinine: EditText
    private lateinit var txtUrineCreatinine: EditText
    private lateinit var txtAlbumin: EditText
    private lateinit var txtGlomerularFiltration: EditText

    private lateinit var radioButtonGroup: RadioGroup
    private lateinit var radio : RadioButton

    private lateinit var btnDiagnosis: Button

    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_main, container, false)

        database=  FirebaseDatabase.getInstance()
        dbReference = database.reference.child("User")
        auth = FirebaseAuth.getInstance()
        var user = auth.currentUser

        txtAge = root.findViewById(R.id.eAgeMain)
        txtTall = root.findViewById(R.id.eTallMain)
        txtWeigth  = root.findViewById(R.id.eWeigthMain)
        txtBloodPresure  = root.findViewById(R.id.ePressureMain)
        txtSerineCreatinine = root.findViewById(R.id.eSerineCreatinineMain)
        txtUrineCreatinine =  root.findViewById(R.id.eUrineCreatinineMain)
        txtAlbumin = root.findViewById(R.id.eAlbuminMain)
        txtGlomerularFiltration = root.findViewById(R.id.eGlomerularFiltration)

        radioButtonGroup =root.findViewById(R.id.radioGroupGender)

        val arrayList = ArrayList<String>()


        btnDiagnosis = root.findViewById(R.id.btnDiagnostisisMain)


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

                var idRadioGroup = radioButtonGroup.checkedRadioButtonId

                if (Age.isEmpty()||Tall.isEmpty()||Weigth.isEmpty()||bloodPressure.isEmpty()||serineCreatinine.isEmpty()||urineCreatinine.isEmpty()||Albumin.isEmpty()||glomerularFiltration.isEmpty()){
                    Toast.makeText(this.context,"LLene todos los campos",Toast.LENGTH_LONG).show()
                }

                else {

                    if (Age.toFloat() >= 0 && Tall.toFloat() >= 0 && Weigth.toFloat() >= 0 && bloodPressure.toFloat() >= 0 &&
                        serineCreatinine.toFloat() >= 0 && urineCreatinine.toFloat() >= 0 && Albumin.toFloat() >= 0 && glomerularFiltration.toFloat() >= 0
                    ) {

                        if (idRadioGroup != -1) {
                            radio = root.findViewById(idRadioGroup)
                            Toast.makeText(context, "on click ${radio.text}", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(context, "on click no selected", Toast.LENGTH_LONG)
                                .show()
                        }


                        val userBD = dbReference.child(user.uid)
                        userBD.child("Gender").setValue(radio.text.toString())

                        val personalDataBD = userBD.child("PersonalData")
                        personalDataBD.child("Age").setValue(Age)
                        personalDataBD.child("Tall").setValue(Tall)
                        personalDataBD.child("Weigth").setValue(Weigth)
                        personalDataBD.child("bloodPresure").setValue(bloodPressure)
                        personalDataBD.child("serineCreatinine").setValue(serineCreatinine)
                        personalDataBD.child("urineCreatinine").setValue(urineCreatinine)
                        personalDataBD.child("Albumin").setValue(Albumin)
                        personalDataBD.child("glomerularFiltration").setValue(glomerularFiltration)


                        //Enviar datos entre fragmentos
                        interfaz?.addDataUser(Age,Tall,Weigth,Albumin)



                        root.eAgeMain.text.clear()
                        root.eTallMain.text.clear()
                        root.eWeigthMain.text.clear()
                        root.ePressureMain.text.clear()
                        root.eSerineCreatinineMain.text.clear()
                        root.eUrineCreatinineMain.text.clear()
                        root.eAlbuminMain.text.clear()
                        root.eGlomerularFiltration.text.clear()

                        //Clasificacion Albumina

                        when (Albumin.toFloat()) {
                            in 0.0..29.9 -> {
                                userBD.child("Etapa_Albumina").setValue("Etapa A1")
                                arrayList.add("Albumina Normal")

                            }

                            in 30.0..300.0 -> {
                                userBD.child("Etapa_Albumina").setValue("Etapa A2")
                                arrayList.add("Albumina Moderadamente Elevada")
                            }

                            else -> {
                                userBD.child("Etapa_Albumina").setValue("Etapa A3")
                                arrayList.add("Albumina Muy Elevada")
                            }

                        }





                        when (radio.text.toString()) {
                            "Female" -> {
                                if (Age > 0.toString() && Age <= 0.5.toString()) {
                                    if (Tall == 60.toString()) {
                                        if (Weigth == 6.toString()) {
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")

                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }

                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 0.6.toString() && Age <= 1.toString()) {
                                    if (Tall == 71.toString()) {
                                        if (Weigth == 9.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 1.toString() && Age <= 3.toString()) {
                                    if (Tall == 90.toString()) {
                                        if (Weigth == 13.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 4.toString() && Age <= 6.toString()) {
                                    if (Tall == 112.toString()) {
                                        if (Weigth == 20.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 7.toString() && Age <= 10.toString()) {
                                    if (Tall == 132.toString()) {
                                        if (Weigth == 28.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 11.toString() && Age <= 14.toString()) {
                                    if (Tall == 157.toString()) {
                                        if (Weigth == 46.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 15.toString() && Age <= 18.toString()) {
                                    if (Tall == 163.toString()) {
                                        if (Weigth == 55.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 19.toString() && Age <= 24.toString()) {
                                    if (Tall == 164.toString()) {
                                        if (Weigth == 58.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                            }

                            "Male" -> {

                                if (Age > 0.toString() && Age <= 0.5.toString()) {
                                    if (Tall == 60.toString()) {
                                        if (Weigth == 6.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            userBD.child("Rango").setValue("Aceptado peso-talla")
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")

                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 0.6.toString() && Age <= 1.toString()) {
                                    if (Tall == 71.toString()) {
                                        if (Weigth == 9.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 1.toString() && Age <= 3.toString()) {
                                    if (Tall == 90.toString()) {
                                        if (Weigth == 13.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 4.toString() && Age <= 6.toString()) {
                                    if (Tall == 112.toString()) {
                                        if (Weigth == 20.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 7.toString() && Age <= 10.toString()) {
                                    if (Tall == 132.toString()) {
                                        if (Weigth == 28.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 11.toString() && Age <= 14.toString()) {
                                    if (Tall == 157.toString()) {
                                        if (Weigth == 45.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }


                                if (Age > 15.toString() && Age <= 18.toString()) {
                                    if (Tall == 176.toString()) {
                                        if (Weigth == 66.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                                if (Age > 19.toString() && Age <= 24.toString()) {
                                    if (Tall == 177.toString()) {
                                        if (Weigth == 72.toString()) {
                                            userBD.child("Rango_Peso_Talla_Edad")
                                                .setValue("Rango Aceptado")
                                            Toast.makeText(
                                                context,
                                                "Rango aceptado",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                            arrayList.add("Te encuentras dentro del rango aceptado para talla,peso y edad")
                                        } else {
                                            arrayList.add("Tu peso no es ideal para tu edad y talla(altura)")
                                        }
                                    } else {
                                        arrayList.add("Tu talla(altura) no es ideal para tu edad")
                                    }
                                }

                            }

                        }


                        when (glomerularFiltration.toFloat()) {
                            in 90.0..120.0 -> {
                                Toast.makeText(context, "Etapa 1 ", Toast.LENGTH_LONG).show()
                                Log.d("glomerular", glomerularFiltration)
                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_1")
                            }

                            in 60.0..89.9 -> {

                                Toast.makeText(context, "Etapa 2 ", Toast.LENGTH_LONG).show()

                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_2")

                            }

                            in 45.0..59.9 -> {
                                Toast.makeText(context, "Etapa 3a ", Toast.LENGTH_LONG).show()

                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_3a")
                            }

                            in 30.0..44.9 -> {
                                Toast.makeText(context, "Etapa 3b ", Toast.LENGTH_LONG).show()

                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_3b")
                            }

                            in 15.0..29.9 -> {
                                Toast.makeText(context, "Etapa 4 ", Toast.LENGTH_LONG).show()

                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_4")
                            }

                            in 00.0..14.9 -> {
                                Toast.makeText(context, "Etapa 5 ", Toast.LENGTH_LONG).show()

                                userBD.child("Etapa_Filtracion_Glomerular").setValue("Etapa_5")
                            }

                            else ->
                                Toast.makeText(context, "Fuera de rango", Toast.LENGTH_LONG).show()

                        }

                    }
                    else {
                        Toast.makeText(
                            this.context,
                            "No se aceptan Valores Negativos",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

            }








        }

        else
        {
            Toast.makeText(context,"Authentication Failed", Toast.LENGTH_LONG).show()
        }

        return root


        }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            interfaz = context as comunicator
        }catch (e:ClassCastException){
            Log.d("exception",e.toString())
        }
    }



    }







