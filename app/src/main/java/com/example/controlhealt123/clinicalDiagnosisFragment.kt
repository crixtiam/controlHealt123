package com.example.controlhealt123


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.controlhealt123.Adapters.DiagnosisCardAdapter
import com.example.controlhealt123.DataModel.ModelPersonalData
import com.example.controlhealt123.DataModel.PersonalData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class clinicalDiagnosisFragment : Fragment() {

    var interfaz : comunicator?  = null

    private lateinit var buttonConsult:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  root= inflater.inflate(R.layout.fragment_clinical_diagnosis, container, false)

       /* database= FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        dbReference= database.getReference()


        var user = auth.currentUser*/


       /* ModelPersonalData.addObserver(this)
        val dataList : ListView = root.findViewById(R.id.data_list)
        //observar
        val data : ArrayList<PersonalData> = ArrayList()*/
    ///    mDiagnosisListAdapter= DiagnosisCardAdapter(this,R.layout.data_card_item,data)

     //   dataList.adapter = mDiagnosisListAdapter


        buttonConsult = root.findViewById(R.id.ButtonConsultDiagnosis)

        buttonConsult.setOnClickListener{

            activity?.let {
                val intent = Intent(it,readDataActivity::class.java)
                it.startActivity(intent)
            }

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

