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
<<<<<<< HEAD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
=======
    val idCoche = intent.extras?.getInt(NUMERO_COCHES) ?: 0
    val opcion = intent.extras?.getString("opcion") ?: 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
<<<<<<< HEAD

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
=======
        val txtMarca = findViewById<EditText>(R.id.editarMarca)
        val txtModelo = findViewById<EditText>(R.id.editarModelo)
        val txtAnnio = findViewById<EditText>(R.id.editarAnnio)
        val txtNumPuertas = findViewById<EditText>(R.id.editarNumPuertas)
        val txtVelocidad = findViewById<EditText>(R.id.editarVelocidad)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val ratingbar = findViewById<RatingBar>(R.id.ratingBar3)
        val btnGuardar = findViewById<Button>(R.id.buttonGuardar)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Marca.values())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        if(opcion == "editar"){
            val coche = RepositorioSingleton.instance.listaCoches.buscar(idCoche)

            txtMarca.setText(coche.marca)
            txtModelo.setText(coche.modelo)
            txtAnnio.setText(coche.añoFabricacion.toInt())
            txtNumPuertas.setText(coche.numPuertas.toInt())
            txtVelocidad.setText(coche.velocidadMaxima)
            spinner.setSelection(coche.imagenMarca.ordinal)
            ratingbar.setRating(coche.opinion.toFloat())
        }
        btnGuardar.setOnClickListener {
            val coche = MarcasCoche(
                txtMarca.text.toString(),
                txtMarca.text.toString(),
                txtAnnio.text.toString().toInt(),
                txtNumPuertas.text.toString().toInt(),
                txtVelocidad.text.toString(),
                spinner.selectedItem as Marca,
                ratingbar.rating
            )

        if(opcion == "nuevo") {
            RepositorioSingleton.instance.listaCoches.nuevoCoche(coche)
        } else {
            RepositorioSingleton.instance.listaCoches.actualizar(idCoche,coche)
        }
            finish()
        }
    }
}


>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
