package com.example.practicaandroid.coches

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Spinner

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.MainActivity

import com.example.practicaandroid.R
import com.example.practicaandroid.coches.CocheActivity.Companion.NUMERO_COCHES
import com.example.practicaandroid.coches.datos.RepositorioSingleton
import com.example.practicaandroid.coches.modelo.Marca
import com.example.practicaandroid.coches.modelo.MarcasCoche

class EditarCocheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idCoche = intent.getIntExtra(CocheActivity.NUMERO_COCHES, -1)

        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_coche)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val marcas = Marca.values()

        val repo= RepositorioSingleton.instance.listaCoches
        val esEdicion=idCoche >= 0 && idCoche < repo.longitud()

        val marca = findViewById<EditText>(R.id.editarMarca)
        val modelo = findViewById<EditText>(R.id.editarModelo)
        val anio = findViewById<EditText>(R.id.editarAnnio)
        val puertas = findViewById<EditText>(R.id.editarNumPuertas)
        val velocidad = findViewById<EditText>(R.id.editarVelocidad)
        val imagen = findViewById<Spinner>(R.id.spinner)
        val rating = findViewById<RatingBar>(R.id.ratingBar3)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, marcas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imagen.adapter = adapter


        if (esEdicion) {
            val coche = RepositorioSingleton.instance.listaCoches.buscar(idCoche)
            marca.setText(coche.marca)
            modelo.setText(coche.modelo)
            anio.setText(coche.añoFabricacion.toString())
            puertas.setText(coche.numPuertas.toString())
            velocidad.setText(coche.velocidadMaxima)
            imagen.setSelection(coche.imagenMarca.ordinal)
            rating.rating = coche.opinion.toString().toFloat()
        }
        findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
            if (esEdicion) {
                val coche = repo.buscar(idCoche)
                coche.marca = marca.text.toString()
                coche.modelo = modelo.text.toString()
                coche.añoFabricacion = anio.text.toString().toInt()
                coche.numPuertas = puertas.text.toString().toInt()
                coche.velocidadMaxima = velocidad.text.toString()
                coche.imagenMarca = imagen.selectedItem as Marca
                coche.opinion = rating.rating

                finish()
            } else {
               repo.nuevoCoche(
                    MarcasCoche(
                        marca = marca.text.toString(),
                        modelo = modelo.text.toString(),
                        añoFabricacion = anio.text.toString().toInt(),
                        numPuertas = puertas.text.toString().toInt(),
                        velocidadMaxima = velocidad.text.toString(),
                        imagenMarca = imagen.selectedItem as Marca,
                        opinion = rating.rating
                    )
                )
                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_atras, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idBoton = item.itemId
        return when (idBoton) {
            R.id.btnAtras -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}