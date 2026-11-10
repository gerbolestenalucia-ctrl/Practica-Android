package com.example.practicaandroid.vista

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaandroid.CocheActivity
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R
import com.example.practicaandroid.datosCoche.RepositorioSingleton

class AdaptadorLista(val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>(){

    val lista = RepositorioSingleton.instance.listaCoches
    val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate(R.layout.tarjeta_coche, parent, false)
        return CreadorItems(vista, contexto)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val coche = lista.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_marca).text = coche.marca
        holder.itemView.findViewById<TextView>(R.id.tarjeta_modelo).text = coche.modelo
        holder.itemView.findViewById<TextView>(R.id.tarjeta_annio).text = coche.añoFabricacion
        holder.itemView.findViewById<TextView>(R.id.tarjeta_numPuertas).text = coche.numPuertas
        holder.itemView.findViewById<TextView>(R.id.tarjeta_velocidad).text = coche.velocidadMaxima
        holder.itemView.findViewById<RatingBar>(R.id.ratingBar2).rating = coche.opinion
        val draw = AppCompatResources.getDrawable(contexto, coche.imagenMarca.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno).setImageDrawable(draw)
    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }

    class CreadorItems(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView) {
        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val posicion = bindingAdapterPosition
                val intent = Intent(contexto, CocheActivity::class.java)
                intent.putExtra(CocheActivity.NUMERO_COCHES, posicion)
                contexto.startActivity(intent)
            }
        }
    }
}