package com.example.practicaandroid.vista

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaandroid.R
import com.example.practicaandroid.coches.CocheActivity
import com.example.practicaandroid.coches.ListaActivity
import com.example.practicaandroid.coches.datos.RepositorioSingleton

class AdaptadorLista() : RecyclerView.Adapter<AdaptadorLista.CreadorItems>(){

    companion object {
        private var instance: AdaptadorLista? = null

        fun getInstance(): AdaptadorLista {
            if(instance != null) {
                return instance!!
            } else {
                instance = AdaptadorLista()
                return instance!!
            }
        }
    }
    val lista = RepositorioSingleton.instance.listaCoches

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista =  LayoutInflater.from(parent.context)
            .inflate(R.layout.tarjeta_coche, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val coche = lista.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_marca).text = coche.marca
        holder.itemView.findViewById<TextView>(R.id.tarjeta_modelo).text = coche.modelo
        holder.itemView.findViewById<TextView>(R.id.tarjeta_annio).text = coche.añoFabricacion.toString()
        holder.itemView.findViewById<TextView>(R.id.tarjeta_numPuertas).text = coche.numPuertas.toString()
        holder.itemView.findViewById<TextView>(R.id.tarjeta_velocidad).text = coche.velocidadMaxima
        holder.itemView.findViewById<RatingBar>(R.id.ratingBar2).rating = coche.opinion
        val draw = AppCompatResources.getDrawable(holder.itemView.context, coche.imagenMarca.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno).setImageDrawable(draw)

        holder.itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
        .setOnClickListener {
            val intent = Intent(holder.itemView.context, CocheActivity::class.java)
            intent.putExtra(CocheActivity.NUMERO_COCHES, position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }
    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView)
}