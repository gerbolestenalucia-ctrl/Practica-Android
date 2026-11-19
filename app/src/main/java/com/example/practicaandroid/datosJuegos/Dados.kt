package com.example.practicaandroid.datosJuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.R
import kotlin.random.Random

class Dados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irDado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spnNumDados = findViewById<Spinner>(R.id.spnNumDado)
        val spnTipoDado = findViewById<Spinner>(R.id.spnTipoDado)
        val lanzar = findViewById<Button>(R.id.btnLanzar)
        val resultado = findViewById<TextView>(R.id.lblResultado)

        val numDados = arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        )
        val tipoDados = arrayOf(
            "4", "6", "8", "10", "12", "20"
        )

        val adapterNum = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            numDados
        )

        val adapterTipo = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            tipoDados
        )

        spnNumDados.adapter = adapterNum
        spnTipoDado.adapter = adapterTipo

        lanzar.setOnClickListener {
            val cantidad = spnNumDados.selectedItem.toString().toInt()
            val caras = spnTipoDado.selectedItem.toString().toInt()

            val tiradas = List(cantidad) {
                Random.nextInt(1, caras + 1)
            }
            val suma = tiradas.sum()

            resultado.text = "Resultado: $tiradas\n Total: $suma"
        }

        val barra = findViewById<Toolbar>(R.id.toolbarJuegoDado)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_atras, menu)
            return super.onCreateOptionsMenu(menu)
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idBoton = item.itemId
        return when (idBoton) {
            R.id.btnAtras -> {
                val intent = Intent(this, JuegosActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
