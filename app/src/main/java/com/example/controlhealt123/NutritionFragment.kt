package com.example.controlhealt123


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass.
 */
class NutritionFragment : Fragment() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    private lateinit var btnNutrition:Button


    private lateinit var txtPan :CheckBox
    private lateinit var txtFrutas :CheckBox
    private lateinit var txtVerduras :CheckBox
    private lateinit var txtPasta :CheckBox
    private lateinit var txtArroz :CheckBox
    private lateinit var txtCarneRoja :CheckBox
    private lateinit var txtPollo :CheckBox
    private lateinit var txtPescado :CheckBox


    private lateinit var txtPanItaliano :CheckBox
    private lateinit var txtMaiz :CheckBox
    private lateinit var txtCerealArroz :CheckBox
    private lateinit var txtCremaTrigo :CheckBox
    private lateinit var txtPalomitasMaiz :CheckBox
    private lateinit var txtGaseosaClara :CheckBox
    private lateinit var txtPanGranoEntero :CheckBox
    private lateinit var txtCerealSalvado :CheckBox
    private lateinit var txtAvena :CheckBox
    private lateinit var txtFrutasSecas :CheckBox
    private lateinit var txtSemillasGirasol :CheckBox
    private lateinit var txtGaseosaOscura :CheckBox
    private val listFoodProtein = mutableListOf<String>()
    private val listFoodPhosphorus = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_nutrition, container, false)


        database = FirebaseDatabase.getInstance()
        dbReference = database.reference.child("User")
        auth = FirebaseAuth.getInstance()

        btnNutrition = root.findViewById(R.id.btn_DietNutrition)

        txtPan = root.findViewById(R.id.panChecked)
        txtFrutas = root.findViewById(R.id.frutasChecked)
        txtVerduras = root.findViewById(R.id.verdurasChecked)
        txtPasta = root.findViewById(R.id.pastaChecked)
        txtArroz = root.findViewById(R.id.arrozChecked)
        txtCarneRoja = root.findViewById(R.id.carneRojaChecked)
        txtPollo = root.findViewById(R.id.polloChecked)
        txtPescado = root.findViewById(R.id.pescadoChecked)


        txtPanItaliano = root.findViewById(R.id.panItalianoChecked)
        txtMaiz = root.findViewById(R.id.maizChecked)
        txtCerealArroz = root.findViewById(R.id.cerealArrozChecked)
        txtCremaTrigo = root.findViewById(R.id.cremaTrigoChecked)
        txtPalomitasMaiz = root.findViewById(R.id.palomitasChecked)
        txtGaseosaClara = root.findViewById(R.id.gaseosaClaraChecked)
        txtPanGranoEntero = root.findViewById(R.id.panEnteroChecked)
        txtCerealSalvado = root.findViewById(R.id.cerealSalvadoChecked)
        txtAvena = root.findViewById(R.id.avenaChecked)
        txtFrutasSecas = root.findViewById(R.id.FrutaSecasChecked)
        txtSemillasGirasol = root.findViewById(R.id.SemillaGirasolChecked)
        txtGaseosaOscura = root.findViewById(R.id.GaseosaOscuraChecked)


        btnNutrition.setOnClickListener{

            proteinFood()
            phosphorusFood()

        }




        return root
    }


    private fun phosphorusFood(){

        var user = auth.currentUser

        var panItaliano = txtPanItaliano.text.toString()
        var maiz = txtMaiz.text.toString()
        var cerealArroz = txtCerealArroz.text.toString()
        var cremaTrigo = txtCremaTrigo.text.toString()
        var palomitas = txtPalomitasMaiz.text.toString()
        var gaseosaClara = txtGaseosaClara.text.toString()
        var panEnteroGrano = txtPanGranoEntero.text.toString()
        var cerealSalvado = txtCerealSalvado.text.toString()
        var avena = txtAvena.text.toString()
        var frutasSecas = txtFrutasSecas.text.toString()
        var semillasGirasol = txtSemillasGirasol.text.toString()
        var gaseosaOscura= txtGaseosaOscura.text.toString()


        if (user!=null){

            val userBD = dbReference.child(user.uid)
            val foodDataBD = userBD.child("Ingested_Food")

            if(txtPanItaliano.isChecked){
                if (!listFoodPhosphorus.contains(panItaliano)) {
                    listFoodPhosphorus.add(panItaliano)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)

                }
            }
            if(!txtPanItaliano.isChecked){
                listFoodPhosphorus.remove(panItaliano)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


            if (txtMaiz.isChecked){
                if (!listFoodPhosphorus.contains(maiz)) {
                    listFoodPhosphorus.add(maiz)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtMaiz.isChecked){
                listFoodPhosphorus.remove(maiz)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }





            if (txtCerealArroz.isChecked){
                if (!listFoodPhosphorus.contains(cerealArroz)) {
                    listFoodPhosphorus.add(cerealArroz)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtCerealArroz.isChecked){
                listFoodPhosphorus.remove(cerealArroz)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)

            }





            if (txtCremaTrigo.isChecked){
                if (!listFoodPhosphorus.contains(cremaTrigo)) {
                    listFoodPhosphorus.add(cremaTrigo)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtCremaTrigo.isChecked){
                listFoodPhosphorus.remove(cremaTrigo)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }



            if (txtPalomitasMaiz.isChecked){
                if (!listFoodPhosphorus.contains(palomitas)) {
                    listFoodPhosphorus.add(palomitas)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }

            if (!txtPalomitasMaiz.isChecked){
                listFoodPhosphorus.remove(palomitas)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


            if (txtGaseosaClara.isChecked){
                if (!listFoodPhosphorus.contains(gaseosaClara)) {
                    listFoodPhosphorus.add(gaseosaClara)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtGaseosaClara.isChecked){
                listFoodPhosphorus.remove(gaseosaClara)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


            if (txtPanGranoEntero.isChecked){
                if (!listFoodPhosphorus.contains(panEnteroGrano)) {
                    listFoodPhosphorus.add(panEnteroGrano)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtPanGranoEntero.isChecked){
                listFoodPhosphorus.remove(panEnteroGrano)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


            if (txtCerealSalvado.isChecked){
                if (!listFoodPhosphorus.contains(cerealSalvado)) {
                    listFoodPhosphorus.add(cerealSalvado)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtCerealSalvado.isChecked){
                listFoodPhosphorus.remove(cerealSalvado)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }

            if (txtAvena.isChecked){
                if (!listFoodPhosphorus.contains(avena)) {
                    listFoodPhosphorus.add(avena)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtAvena.isChecked){
                listFoodPhosphorus.remove(avena)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }



            if (txtFrutasSecas.isChecked){
                if (!listFoodPhosphorus.contains(frutasSecas)) {
                    listFoodPhosphorus.add(frutasSecas)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }
            if (!txtFrutasSecas.isChecked){
                listFoodPhosphorus.remove(frutasSecas)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


            if (txtSemillasGirasol.isChecked){
                if (!listFoodPhosphorus.contains(semillasGirasol)) {
                    listFoodPhosphorus.add(semillasGirasol)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }

            if (!txtSemillasGirasol.isChecked){
                listFoodPhosphorus.remove(semillasGirasol)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }

            if (txtGaseosaOscura.isChecked){
                if (!listFoodPhosphorus.contains(gaseosaOscura)) {
                    listFoodPhosphorus.add(gaseosaOscura)
                    foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
                }
            }

            if (!txtGaseosaOscura.isChecked){
                listFoodPhosphorus.remove(gaseosaOscura)
                foodDataBD.child("Phosphorus").setValue(listFoodPhosphorus)
            }


        }
        else{
            Toast.makeText(context,"No selected phosphorus food",Toast.LENGTH_LONG).show()
        }


    }

    private fun proteinFood(){
        var user = auth.currentUser


        var pan = txtPan.text.toString()
        var frutas = txtFrutas.text.toString()
        var verduras = txtVerduras.text.toString()
        var pasta = txtPasta.text.toString()
        var arroz = txtArroz.text.toString()
        var carneRoja = txtCarneRoja.text.toString()
        var pollo = txtPollo.text.toString()
        var pescado = txtPescado.text.toString()

        if (user!=null){
            val userBD = dbReference.child(user.uid)
            val foodDataBD = userBD.child("Ingested_Food")


            if (txtPan.isChecked){
                if (!listFoodProtein.contains(pan)){
                    listFoodProtein.add(pan)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtPan.isChecked){
                    listFoodProtein.remove(pan)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
            }



            if (txtFrutas.isChecked){
                if (!listFoodProtein.contains(frutas))
                {
                    listFoodProtein.add(frutas)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtFrutas.isChecked){
                    listFoodProtein.remove(frutas)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
            }

            if (txtVerduras.isChecked){
                if (!listFoodProtein.contains(verduras)){
                    listFoodProtein.add(verduras)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtVerduras.isChecked){
                listFoodProtein.remove(verduras)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }


            if (txtPasta.isChecked){
                if (!listFoodProtein.contains(pasta)){
                    listFoodProtein.add(pasta)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtPasta.isChecked){
                listFoodProtein.remove(pasta)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }

            if (txtArroz.isChecked){
                if (!listFoodProtein.contains(arroz)){
                    listFoodProtein.add(arroz)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtArroz.isChecked){
                listFoodProtein.remove(arroz)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }

            if (txtCarneRoja.isChecked){
                if (!listFoodProtein.contains(carneRoja)){
                    listFoodProtein.add(carneRoja)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtCarneRoja.isChecked){
                listFoodProtein.remove(carneRoja)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }


            if (txtPollo.isChecked){
                if (!listFoodProtein.contains(pollo)){
                    listFoodProtein.add(pollo)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }
            if (!txtPollo.isChecked){
                listFoodProtein.remove(pollo)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }


            if (txtPescado.isChecked){
                if (!listFoodProtein.contains(pescado)){
                    listFoodProtein.add(pescado)
                    foodDataBD.child("Proteins").setValue(listFoodProtein)
                }
            }

            if (!txtPescado.isChecked){
                listFoodProtein.remove(pescado)
                foodDataBD.child("Proteins").setValue(listFoodProtein)
            }

            else{
                Toast.makeText(context,"Food Proteins no selected",Toast.LENGTH_LONG).show()
            }



        }

        else{
            Toast.makeText(context,"User Null",Toast.LENGTH_LONG).show()
        }

    }



    } //end fragment




