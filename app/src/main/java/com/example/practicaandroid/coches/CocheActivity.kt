package com.example.practicaandroid.coches

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R
import com.example.practicaandroid.coches.datos.RepositorioSingleton
import org.w3c.dom.Text

class CocheActivity : AppCompatActivity() {

    companion object {
        const val NUMERO_COCHES = "numero coche"
    }

    var idCoche: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coche)
        idCoche = intent.getIntExtra(NUMERO_COCHES, -1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbarCoche)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
        override fun onResume() {
            super.onResume()

            val lista = RepositorioSingleton.instance.listaCoches
            val coche = lista.buscar(idCoche)

            findViewById<TextView>(R.id.textMarca).text = coche.marca
            val icono = findViewById<ImageView>(R.id.icono)
            val draw = AppCompatResources.getDrawable(this, coche.imagenMarca.imagen)
            icono.setImageDrawable(draw)
            val textoModelo = findViewById<TextView>(R.id.textModelo)
            val textoAnio = findViewById<TextView>(R.id.textAnio)
            val textoPuertas = findViewById<TextView>(R.id.textPuertas)
            val textoVelocidad = findViewById<TextView>(R.id.textVelocidad)
            textoModelo.text = coche.modelo
            textoAnio.text = coche.añoFabricacion.toString()
            textoPuertas.text = coche.numPuertas.toString()
            textoVelocidad.text = coche.velocidadMaxima
            val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
            ratingBar.rating = coche.opinion.toString().toFloat()

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_botones_coche, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idBoton = item.itemId
        return when (idBoton) {
            R.id.btnMenuEditar -> {
                val intent = Intent(this, EditarCocheActivity::class.java)
                intent.putExtra(NUMERO_COCHES, idCoche)
                startActivity(intent)
                true
            }
            R.id.btnMenuAñadir -> {
                val intent = Intent(this, EditarCocheActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.btnEliminarCoche -> {
                AlertDialog.Builder(this)
                    .setTitle("Eliminar coche")
                    .setMessage("¿Seguro que quieres eliminar el coche?")
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Eliminar"){p0,p1 ->
                        RepositorioSingleton.instance.listaCoches.borrar(idCoche)
                        finish()
                    }
                    .show()
                true
            }
            R.id.btnSalir -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}