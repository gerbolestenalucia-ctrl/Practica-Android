package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.datosCoche.RepositorioSingleton

class CocheActivity : AppCompatActivity() {

    companion object {
        val NUMERO_COCHES = "numero coche"
    }

    var idCoche: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val idCoche = intent.extras?.getInt(NUMERO_COCHES) ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_coche)
        idCoche = intent.getIntExtra(NUMERO_COCHES, -1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbar_coche)
        setSupportActionBar(barra)
    }

        override fun onResume() {
            val lista = RepositorioSingleton.instance.listaCoches
            val coche = lista.buscar(idCoche)
            findViewById<TextView>(R.id.textMarca).text = coche.marca
            val icono = findViewById<ImageView>(R.id.icono)
            val draw = AppCompatResources.getDrawable(this, coche.imagenMarca.imagen)
            icono.setImageDrawable(draw)
            val textoModelo = findViewById<TextView>(R.id.textModelo)
            val textoAnio = findViewById<TextView>(R.id.textAnio)
            textoModelo.text = coche.modelo
            textoAnio.text = coche.añoFabricacion.toString()
            val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
            ratingBar.rating = coche.opinion.toString().toFloat()
            super.onResume()
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_vista_coche, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val idBoton = item.itemId
        return when (idBoton) {
            R.id.boton_menu_editar -> {
                val intent = Intent(this, EditarCocheActivity::class.java)
                intent.putExtra(NUMERO_COCHES, idCoche)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}