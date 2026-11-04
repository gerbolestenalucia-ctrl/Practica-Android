package com.example.practicaandroid

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CocheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idCoche = intent.extras?.getInt("numero coche") ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val coche = MainActivity.listaCoches.buscar(idCoche)
        findViewById<TextView>(R.id.textMarca).text = coche.marca
        val icono = findViewById<ImageView>(R.id.icono)
        val draw = AppCompatResources.getDrawable(this, coche.imagenMarca.imagen)
        icono.setImageDrawable(draw)
        val textoModelo = findViewById<TextView>(R.id.textModelo)
        val textoAnio = findViewById<TextView>(R.id.textAnio)
        val textoPuertas = findViewById<TextView>(R.id.textPuertas)
        val textoVelocidad = findViewById<TextView>(R.id.textVelocidad)
        textoModelo.text = coche.modelo
        textoAnio.text = coche.añoFabricacion
        textoPuertas.text = coche.numPuertas
        textoVelocidad.text = coche.velocidadMaxima
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = coche.opinion.toFloat()
    }
}