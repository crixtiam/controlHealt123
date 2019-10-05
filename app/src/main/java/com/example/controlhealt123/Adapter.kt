package com.example.controlhealt123

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.userdata_item.view.*

class Adapter : RecyclerView.Adapter<Adapter.inventoryViewHolder> {


    private var listPeluches: MutableList<UserData>? = null
    private var totalListPeluches : MutableList<UserData>
    private var context : Context? = null

    constructor(listPeluches: MutableList<UserData>,context: Context){
        this.listPeluches = listPeluches
        totalListPeluches=ArrayList(listPeluches)
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): inventoryViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.userdata_item,parent,false)
        return inventoryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listPeluches?.size!!

    }



    override fun onBindViewHolder(holder: inventoryViewHolder, position: Int) {
        val peluches = listPeluches!![position]
        holder.loadItem(peluches)
    }




    class inventoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun loadItem(userdata:UserData){

            itemView.tNombre.text = userdata.Age
            itemView.tid.text = userdata.Tall
            itemView.tPrecio.text = userdata.Weigth
            itemView.tStock.text = userdata.Albumina

            itemView.setOnClickListener{
                //Toast.makeText(itemView.context,userdata.nombre,Toast.LENGTH_LONG).show()
            }

        }
    }
}