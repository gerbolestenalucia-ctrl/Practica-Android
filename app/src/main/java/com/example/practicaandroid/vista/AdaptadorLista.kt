package com.example.practicaandroid.vista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R

class AdaptadorLista(val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>(){

    val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate(R.layout.tarjeta_coche, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val coche = MainActivity.listaCoches.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_marca).text = coche.marca
    }

    override fun getItemCount(): Int {
        return MainActivity.listaCoches.longitud()
    }

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}