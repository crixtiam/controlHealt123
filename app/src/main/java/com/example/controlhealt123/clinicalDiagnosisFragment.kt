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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class clinicalDiagnosisFragment : Fragment() {

    var interfaz : comunicator?  = null
    private lateinit var recyclerView: RecyclerView

    private lateinit var buttonConsult:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  root= inflater.inflate(R.layout.fragment_clinical_diagnosis, container, false)

        var arrayUserData = arguments?.getParcelableArrayList<UserData>("send")
        arrayUserData?.toMutableList()
        recyclerView  = root.findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)

        val pelucheAdapter = Adapter(arrayUserData!!,this.requireContext())
        recyclerView.adapter = pelucheAdapter




       /* buttonConsult = root.findViewById(R.id.ButtonConsultDiagnosis)

        buttonConsult.setOnClickListener{

            activity?.let {
                val intent = Intent(it,readDataActivity::class.java)
                it.startActivity(intent)
            }

        }*/


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

