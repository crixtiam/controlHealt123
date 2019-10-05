package com.example.controlhealt123


import android.content.Context
import android.os.Bundle
import android.util.Log
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
import kotlinx.android.synthetic.main.fragment_nutrition.*

/**
 * A simple [Fragment] subclass.
 */
class NutritionFragment : Fragment() {

    var interfaz : comunicator?  = null


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


    private lateinit var txtAceiteOliva : CheckBox
    private lateinit var txtAceiteCacahuate : CheckBox
    private lateinit var txtAceiteMaiz : CheckBox
    private lateinit var txtMantequilla : CheckBox
    private lateinit var txtMantecaCerdo : CheckBox


    private lateinit var txtJamon :CheckBox
    private lateinit var txtTocino :CheckBox
    private lateinit var txtAceituna :CheckBox
    private lateinit var txtSalchicha :CheckBox
    private lateinit var txtVerdurasLata :CheckBox
    private lateinit var txtSopaLata :CheckBox
    private lateinit var txtComidaCongelada :CheckBox
    private lateinit var txtPepinillo :CheckBox


    private lateinit var txtManzana : CheckBox
    private lateinit var txtUva : CheckBox
    private lateinit var txtPina : CheckBox
    private lateinit var txtArandano : CheckBox
    private lateinit var txtColiflor : CheckBox
    private lateinit var txtCalabaza : CheckBox
    private lateinit var txtCebolla : CheckBox
    private lateinit var txtPimiento : CheckBox
    private lateinit var txtRabano : CheckBox
    private lateinit var txtLechuga : CheckBox
    private lateinit var txtPitalla : CheckBox
    private lateinit var txtTortilla : CheckBox
    private lateinit var txtPanBlanco : CheckBox
    private lateinit var txtCarneRes : CheckBox
    private lateinit var txtArrozBlanco : CheckBox
    private lateinit var txtAguacate : CheckBox
    private lateinit var txtBanano : CheckBox
    private lateinit var txtMelon : CheckBox
    private lateinit var txtNaranja : CheckBox
    private lateinit var txtCiruela : CheckBox
    private lateinit var txtPasas : CheckBox
    private lateinit var txtAlcachofas : CheckBox
    private lateinit var txtPlatano : CheckBox
    private lateinit var txtEspinaca : CheckBox
    private lateinit var txtPapa : CheckBox
    private lateinit var txtTomate : CheckBox
    private lateinit var txtProductoSalvado : CheckBox
    private lateinit var txtGranola : CheckBox
    private lateinit var txtFrijol : CheckBox
    private lateinit var txtArrozIntegral: CheckBox



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
    private val listFatFood = mutableListOf<String>()
    private val listSodiumFood = mutableListOf<String>()
    private val listPotassiumFood = mutableListOf<String>()

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

        txtAceiteOliva = root.findViewById(R.id.aceiteOlivaChecked)
        txtAceiteCacahuate = root.findViewById(R.id.aceiteCacahuateChecked)
        txtAceiteMaiz = root.findViewById(R.id.aceiteMaizChecked)
        txtMantequilla = root.findViewById(R.id.mantequillaChecked)
        txtMantecaCerdo = root.findViewById(R.id.mantecaCerdoChecked)


        txtJamon = root.findViewById(R.id.jamonChecked)
        txtTocino = root.findViewById(R.id.tocinoChecked)
        txtAceituna = root.findViewById(R.id.aceitunasChecked)
        txtSalchicha = root.findViewById(R.id.salchichasChecked)
        txtVerdurasLata = root.findViewById(R.id.verdurasLataChecked)
        txtSopaLata = root.findViewById(R.id.sopaLataChecked)
        txtComidaCongelada = root.findViewById(R.id.comidaCongeladaChecked)
        txtPepinillo = root.findViewById(R.id.pepinilloChecked)



        txtManzana = root.findViewById(R.id.manzanaChecked)
        txtUva = root.findViewById(R.id.uvaChecked)
        txtPina = root.findViewById(R.id.pinaChecked)
        txtArandano = root.findViewById(R.id.arandanoChecked)
        txtColiflor = root.findViewById(R.id.coliflorChecked)
        txtCalabaza = root.findViewById(R.id.calabazaChecked)
        txtCebolla = root.findViewById(R.id.cebollaChecked)
        txtPimiento = root.findViewById(R.id.pimientoChecked)
        txtRabano = root.findViewById(R.id.rabanoChecked)
        txtLechuga = root.findViewById(R.id.lechugaChecked)
        txtPitalla = root.findViewById(R.id.pitallaChecked)
        txtTortilla = root.findViewById(R.id.tortillaChecked)
        txtPanBlanco = root.findViewById(R.id.panBlancoChecked)
        txtCarneRes = root.findViewById(R.id.carneResChecked)
        txtArrozBlanco = root.findViewById(R.id.arrozBlancoChecked)
        txtAguacate = root.findViewById(R.id.aguacateChecked)
        txtBanano = root.findViewById(R.id.bananoChecked)
        txtMelon = root.findViewById(R.id.melonChecked)
        txtNaranja = root.findViewById(R.id.naranjaChecked)
        txtCiruela = root.findViewById(R.id.ciruelaChecked)
        txtPasas = root.findViewById(R.id.pasasChecked)
        txtAlcachofas = root.findViewById(R.id.AlcachofaChecked)
        txtPlatano = root.findViewById(R.id.platanoChecked)
        txtEspinaca  = root.findViewById(R.id.espinacaChecked)
        txtPapa = root.findViewById(R.id.papaChecked)
        txtTomate = root.findViewById(R.id.tomateChecked)
        txtProductoSalvado = root.findViewById(R.id.productoSalvado)
        txtGranola = root.findViewById(R.id.granolaChecked)
        txtFrijol = root.findViewById(R.id.frijoChecked)
        txtArrozIntegral = root.findViewById(R.id.arrozIntegralChecked)




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
            fatFood()
            sodiumFood()
            potassiumFood()
            phosphorusFood()

            Toast.makeText(this.context,"Datos enviados a la base de datos",Toast.LENGTH_LONG).show()

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

    private fun fatFood(){

        var user = auth.currentUser

        var aceiteOliva = txtAceiteOliva.text.toString()
        var aceiteCacahuate = txtAceiteCacahuate.text.toString()
        var aceiteMaiz = txtAceiteMaiz.text.toString()
        var mantequilla = txtMantequilla.text.toString()
        var mantecaCerdo = txtMantecaCerdo.text.toString()

        if (user!=null){

            val userBD = dbReference.child(user.uid)
            val foodDataBD = userBD.child("Ingested_Food")

            if (txtAceiteOliva.isChecked){
                if (!listFatFood.contains(aceiteOliva)){
                    listFatFood.add(aceiteOliva)
                    foodDataBD.child("Fat_Food").setValue(listFatFood)
                }
            }
            if (!txtAceiteOliva.isChecked){
                listFatFood.remove(aceiteOliva)
                foodDataBD.child("Fat_Food").setValue(listFatFood)
            }


            if (txtAceiteCacahuate.isChecked){
                if (!listFatFood.contains(aceiteCacahuate)) {
                    listFatFood.add(aceiteCacahuate)
                    foodDataBD.child("Fat_Food").setValue(listFatFood)
                }
            }

            if (!txtAceiteCacahuate.isChecked){
                listFatFood.remove(aceiteCacahuate)
                foodDataBD.child("Fat_Food").setValue(listFatFood)
            }

            if (txtAceiteMaiz.isChecked){
                if (!listFatFood.contains(aceiteMaiz)){
                    listFatFood.add(aceiteMaiz)
                    foodDataBD.child("Fat_Food").setValue(listFatFood)
                }
            }

            if (!txtAceiteMaiz.isChecked){
                listFatFood.remove(aceiteMaiz)
                foodDataBD.child("Fat_Food").setValue(listFatFood)
            }

            if (txtMantequilla.isChecked){
                if (!listFatFood.contains(mantequilla)) {
                    listFatFood.add(mantequilla)
                    foodDataBD.child("Fat_Food").setValue(listFatFood)
                }
            }
            if (!txtMantequilla.isChecked){
                listFatFood.remove(mantequilla)
                foodDataBD.child("Fat_Food").setValue(listFatFood)
            }

            if (txtMantecaCerdo.isChecked){
                if (!listFatFood.contains(mantecaCerdo)){
                    listFatFood.add(mantecaCerdo)
                    foodDataBD.child("Fat_Food").setValue(listFatFood)
                }
            }

            if (!txtMantecaCerdo.isChecked){
                listFatFood.remove(mantecaCerdo)
                foodDataBD.child("Fat_Food").setValue(listFatFood)
            }

        }

        else{
            Toast.makeText(context,"User Null",Toast.LENGTH_LONG).show()
        }

    }


    private fun sodiumFood(){

        var user = auth.currentUser

        var jamon = txtJamon.text.toString()
        var tocino = txtTocino.text.toString()
        var aceituna = txtAceituna.text.toString()
        var salchicha = txtSalchicha.text.toString()
        var verduraLata = txtVerdurasLata.text.toString()
        var sopaLata = txtSopaLata.text.toString()
        var comidaCongelada = txtComidaCongelada.text.toString()
        var pepinillo = txtPepinillo.text.toString()

        if (user!=null){

            val userBD = dbReference.child(user.uid)
            val foodDataBD = userBD.child("Ingested_Food")

            if (txtJamon.isChecked){
                if (!listSodiumFood.contains(jamon)){
                    listSodiumFood.add(jamon)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtJamon.isChecked){
                listSodiumFood.remove(jamon)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtTocino.isChecked){
                if (!listSodiumFood.contains(tocino)){
                    listSodiumFood.add(tocino)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtTocino.isChecked){
                listSodiumFood.remove(tocino)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtAceituna.isChecked){
                if (!listSodiumFood.contains(aceituna)){
                    listSodiumFood.add(aceituna)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtAceituna.isChecked){
                listSodiumFood.remove(aceituna)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtSalchicha.isChecked){
                if (!listSodiumFood.contains(salchicha)){
                    listSodiumFood.add(salchicha)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtSalchicha.isChecked){
                listSodiumFood.remove(salchicha)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }

            if (txtVerdurasLata.isChecked){
                if (!listSodiumFood.contains(verduraLata)){
                    listSodiumFood.add(verduraLata)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtVerdurasLata.isChecked){
                listSodiumFood.remove(verduraLata)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtSopaLata.isChecked){
                if (!listSodiumFood.contains(sopaLata)){
                    listSodiumFood.add(sopaLata)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtSopaLata.isChecked){
                listSodiumFood.remove(sopaLata)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtComidaCongelada.isChecked){
                if (!listSodiumFood.contains(comidaCongelada)){
                    listSodiumFood.add(comidaCongelada)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtComidaCongelada.isChecked){
                listSodiumFood.remove(comidaCongelada)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }


            if (txtPepinillo.isChecked){
                if (!listSodiumFood.contains(pepinillo)){
                    listSodiumFood.add(pepinillo)
                    foodDataBD.child("Sodium").setValue(listSodiumFood)
                }
            }
            if (!txtPepinillo.isChecked){
                listSodiumFood.remove(pepinillo)
                foodDataBD.child("Sodium").setValue(listSodiumFood)
            }

        }

        else{
            Toast.makeText(context,"User Null",Toast.LENGTH_LONG).show()
        }
    }

    private fun potassiumFood(){
        var user = auth.currentUser

        val manzana = txtManzana.text.toString()
        val uva = txtUva.text.toString()
        val pina = txtPina.text.toString()
        val arandano = txtArandano.text.toString()
        val colifor= txtColiflor.text.toString()
        val calabaza = txtCalabaza.text.toString()
        val cebolla = txtCebolla.text.toString()
        val pimiento = txtPimiento.text.toString()
        val rabano = txtRabano.text.toString()
        val lechuga = txtLechuga.text.toString()
        val pitalla = txtPitalla.text.toString()
        val tortilla = txtTortilla.text.toString()
        val panBlanco = txtPanBlanco.text.toString()
        val carneRes = txtCarneRes.text.toString()
        val arrozBlanco = txtArrozBlanco.text.toString()
        val aguacate = txtAguacate.text.toString()
        val banano = txtBanano.text.toString()
        val melon = txtMelon.text.toString()
        val naranja = txtNaranja.text.toString()
        val ciruela = txtCiruela.text.toString()
        val pasas = txtPasas.text.toString()
        val alcachofas= txtAlcachofas.text.toString()
        val platano = txtPlatano.text.toString()
        val espinaca = txtEspinaca.text.toString()
        val papa = txtPapa.text.toString()
        val tomate = txtTomate.text.toString()
        val productoSalvado = txtProductoSalvado.text.toString()
        val granola = txtGranola.text.toString()
        val frijol = txtFrijol.text.toString()
        val arrozIntegral = txtArrozIntegral.text.toString()


        if (user!=null) {

            val userBD = dbReference.child(user.uid)
            val foodDataBD = userBD.child("Ingested_Food")

            if (txtManzana.isChecked) {
                if (!listPotassiumFood.contains(manzana)) {
                    listPotassiumFood.add(manzana)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtManzana.isChecked) {
                listPotassiumFood.remove(manzana)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


            if (txtUva.isChecked) {
                if (!listPotassiumFood.contains(uva)) {
                    listPotassiumFood.add(uva)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtUva.isChecked) {
                listPotassiumFood.remove(uva)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


            if (txtPina.isChecked) {
                if (!listPotassiumFood.contains(pina)) {
                    listPotassiumFood.add(pina)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPina.isChecked) {
                listPotassiumFood.remove(pina)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


            if (txtArandano.isChecked) {
                if (!listPotassiumFood.contains(arandano)) {
                    listPotassiumFood.add(arandano)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtArandano.isChecked) {
                listPotassiumFood.remove(arandano)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


            if (txtColiflor.isChecked) {
                if (!listPotassiumFood.contains(colifor)) {
                    listPotassiumFood.add(colifor)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtColiflor.isChecked) {
                listPotassiumFood.remove(colifor)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


            if (txtCalabaza.isChecked) {
                if (!listPotassiumFood.contains(calabaza)) {
                    listPotassiumFood.add(calabaza)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtCalabaza.isChecked) {
                listPotassiumFood.remove(calabaza)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtCebolla.isChecked) {
                if (!listPotassiumFood.contains(cebolla)) {
                    listPotassiumFood.add(cebolla)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtCebolla.isChecked) {
                listPotassiumFood.remove(cebolla)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPimiento.isChecked) {
                if (!listPotassiumFood.contains(pimiento)) {
                    listPotassiumFood.add(pimiento)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPimiento.isChecked) {
                listPotassiumFood.remove(pimiento)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtRabano.isChecked) {
                if (!listPotassiumFood.contains(rabano)) {
                    listPotassiumFood.add(rabano)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtRabano.isChecked) {
                listPotassiumFood.remove(rabano)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtLechuga.isChecked) {
                if (!listPotassiumFood.contains(lechuga)) {
                    listPotassiumFood.add(lechuga)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtLechuga.isChecked) {
                listPotassiumFood.remove(lechuga)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPitalla.isChecked) {
                if (!listPotassiumFood.contains(pitalla)) {
                    listPotassiumFood.add(pitalla)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPitalla.isChecked) {
                listPotassiumFood.remove(pitalla)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtTortilla.isChecked) {
                if (!listPotassiumFood.contains(tortilla)) {
                    listPotassiumFood.add(tortilla)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtTortilla.isChecked) {
                listPotassiumFood.remove(tortilla)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPanBlanco.isChecked) {
                if (!listPotassiumFood.contains(panBlanco)) {
                    listPotassiumFood.add(panBlanco)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPanBlanco.isChecked) {
                listPotassiumFood.remove(panBlanco)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtCarneRes.isChecked) {
                if (!listPotassiumFood.contains(carneRes)) {
                    listPotassiumFood.add(carneRes)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtCarneRes.isChecked) {
                listPotassiumFood.remove(carneRes)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtArrozBlanco.isChecked) {
                if (!listPotassiumFood.contains(arrozBlanco)) {
                    listPotassiumFood.add(arrozBlanco)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtArrozBlanco.isChecked) {
                listPotassiumFood.remove(arrozBlanco)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtAguacate.isChecked) {
                if (!listPotassiumFood.contains(aguacate)) {
                    listPotassiumFood.add(aguacate)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtAguacate.isChecked) {
                listPotassiumFood.remove(aguacate)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtBanano.isChecked) {
                if (!listPotassiumFood.contains(banano)) {
                    listPotassiumFood.add(banano)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtBanano.isChecked) {
                listPotassiumFood.remove(banano)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtMelon.isChecked) {
                if (!listPotassiumFood.contains(melon)) {
                    listPotassiumFood.add(melon)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtMelon.isChecked) {
                listPotassiumFood.remove(melon)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtNaranja.isChecked) {
                if (!listPotassiumFood.contains(naranja)) {
                    listPotassiumFood.add(naranja)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtNaranja.isChecked) {
                listPotassiumFood.remove(naranja)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtCiruela.isChecked) {
                if (!listPotassiumFood.contains(ciruela)) {
                    listPotassiumFood.add(ciruela)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtCiruela.isChecked) {
                listPotassiumFood.remove(ciruela)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPasas.isChecked) {
                if (!listPotassiumFood.contains(pasas)) {
                    listPotassiumFood.add(pasas)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPasas.isChecked) {
                listPotassiumFood.remove(pasas)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtAlcachofas.isChecked) {
                if (!listPotassiumFood.contains(alcachofas)) {
                    listPotassiumFood.add(alcachofas)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtAlcachofas.isChecked) {
                listPotassiumFood.remove(alcachofas)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPlatano.isChecked) {
                if (!listPotassiumFood.contains(platano)) {
                    listPotassiumFood.add(platano)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPlatano.isChecked) {
                listPotassiumFood.remove(platano)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtEspinaca.isChecked) {
                if (!listPotassiumFood.contains(espinaca)) {
                    listPotassiumFood.add(espinaca)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtEspinaca.isChecked) {
                listPotassiumFood.remove(espinaca)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtPapa.isChecked) {
                if (!listPotassiumFood.contains(papa)) {
                    listPotassiumFood.add(papa)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtPapa.isChecked) {
                listPotassiumFood.remove(papa)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtTomate.isChecked) {
                if (!listPotassiumFood.contains(tomate)) {
                    listPotassiumFood.add(tomate)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtTomate.isChecked) {
                listPotassiumFood.remove(tomate)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtProductoSalvado.isChecked) {
                if (!listPotassiumFood.contains(productoSalvado)) {
                    listPotassiumFood.add(productoSalvado)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtProductoSalvado.isChecked) {
                listPotassiumFood.remove(productoSalvado)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtGranola.isChecked) {
                if (!listPotassiumFood.contains(granola)) {
                    listPotassiumFood.add(granola)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtGranola.isChecked) {
                listPotassiumFood.remove(granola)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtFrijol.isChecked) {
                if (!listPotassiumFood.contains(frijol)) {
                    listPotassiumFood.add(frijol)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtFrijol.isChecked) {
                listPotassiumFood.remove(frijol)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }

            if (txtArrozIntegral.isChecked) {
                if (!listPotassiumFood.contains(arrozIntegral)) {
                    listPotassiumFood.add(arrozIntegral)
                    foodDataBD.child("Potassium").setValue(listPotassiumFood)
                }
            }
            if (!txtArrozIntegral.isChecked) {
                listPotassiumFood.remove(arrozIntegral)
                foodDataBD.child("Potassium").setValue(listPotassiumFood)
            }


        }

        else
        {
            Toast.makeText(context,"User Null",Toast.LENGTH_LONG).show()
        }



        }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            interfaz = context as comunicator
        }catch (e:ClassCastException){
            Log.d("exception",e.toString())
        }
    }


} //end fragment




