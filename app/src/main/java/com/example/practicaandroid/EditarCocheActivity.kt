package com.example.practicaandroid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.modelo.MarcasCoche
import com.example.practicaandroid.CocheActivity.Companion.NUMERO_COCHES
import com.example.practicaandroid.datosCoche.RepositorioSingleton
import com.example.practicaandroid.modeloCoche.Marca

class EditarCocheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idCoche = intent.extras?.getInt("numero coche")

        if(idCoche != null) {
            val coche = RepositorioSingleton.instance.listaCoches.buscar(idCoche)
            val marca = findViewById<EditText>(R.id.editarMarca)
            marca.setText(coche.marca)
            val modelo = findViewById<EditText>(R.id.editarModelo)
            modelo.setText(coche.modelo)
            val anio = findViewById<EditText>(R.id.editarAnnio)
            anio.setText(coche.añoFabricacion.toString())
            val puertas = findViewById<EditText>(R.id.editarNumPuertas)
            puertas.setText(coche.numPuertas.toString())
            val velocidad = findViewById<EditText>(R.id.editarVelocidad)
            velocidad.setText(coche.velocidadMaxima.toString())
            val rating = findViewById<RatingBar>(R.id.editarRating)
                rating.rating = coche.opinion.toFloat()

            findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
                coche.marca = marca.text.toString()
                coche.modelo = modelo.text.toString()
                coche.añoFabricacion = anio.text.toString().toInt()
                coche.numPuertas = puertas.text.toString().toInt()
                coche.velocidadMaxima = velocidad.text.toString()
                coche.opinion = rating.rating
                finish()
            }
        }
    }
}