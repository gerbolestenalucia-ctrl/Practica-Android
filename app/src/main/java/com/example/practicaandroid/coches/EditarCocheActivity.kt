package com.example.practicaandroid.coches

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
import com.example.practicaandroid.R
import com.example.practicaandroid.coches.modelo.MarcasCoche
import com.example.practicaandroid.coches.CocheActivity.Companion.NUMERO_COCHES
import com.example.practicaandroid.coches.datos.RepositorioSingleton
import com.example.practicaandroid.coches.modelo.Marca

class EditarCocheActivity : AppCompatActivity() {

    val idCoche = intent.extras?.getInt(NUMERO_COCHES) ?: 0
    val opcion = intent.extras?.getString("opcion") ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtMarca = findViewById<EditText>(R.id.editarMarca)
        val txtModelo = findViewById<EditText>(R.id.editarModelo)
        val txtAnnio = findViewById<EditText>(R.id.editarAnnio)
        val txtNumPuertas = findViewById<EditText>(R.id.editarNumPuertas)
        val txtVelocidad = findViewById<EditText>(R.id.editarVelocidad)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val ratingbar = findViewById<RatingBar>(R.id.ratingBar3)
        val btnGuardar = findViewById<Button>(R.id.buttonGuardar)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            Marca.values())

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        if (opcion == "editar") {
            val coche = RepositorioSingleton.instance.listaCoches.buscar(idCoche)

            txtMarca.setText(coche.marca)
            txtModelo.setText(coche.modelo)
            txtAnnio.setText(coche.añoFabricacion.toString().toInt())
            txtNumPuertas.setText(coche.numPuertas.toString().toInt())
            txtVelocidad.setText(coche.velocidadMaxima)
            spinner.setSelection(coche.imagenMarca.ordinal)
            ratingbar.setRating(coche.opinion.toString().toFloat())
        }
        btnGuardar.setOnClickListener {
            val coche = MarcasCoche(
                txtMarca.text.toString(),
                txtModelo.text.toString(),
                txtAnnio.text.toString().toInt(),
                txtNumPuertas.text.toString().toInt(),
                txtVelocidad.text.toString(),
                spinner.selectedItem as Marca,
                ratingbar.rating
            )

            if (opcion == "nuevo") {
                RepositorioSingleton.instance.listaCoches.nuevoCoche(coche)
            } else {
                RepositorioSingleton.instance.listaCoches.actualizar(idCoche, coche)
            }
            finish()
        }
    }
}