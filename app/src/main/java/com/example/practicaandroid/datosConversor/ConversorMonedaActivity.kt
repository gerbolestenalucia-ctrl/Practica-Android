package com.example.practicaandroid.datosConversor

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R

class ConversorMonedaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor_moneda)

        val editText = findViewById<EditText>(R.id.editTextNumber)
        val spinnerOrigen = findViewById<Spinner>(R.id.spinner3)
        val spinnerDestino = findViewById<Spinner>(R.id.spinner4)
        val boton = findViewById<Button>(R.id.buttonConvertir)
        val resultado = findViewById<TextView>(R.id.textViewResultado)

        val monedas = arrayOf(
            "Euros",
            "Pesos",
            "Dolares",
            "Libras"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            monedas)

        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter

        boton.setOnClickListener {
            val cantidad = editText.text.toString().toDouble()

            val origen = spinnerOrigen.selectedItem.toString()
            val destino = spinnerDestino.selectedItem.toString()

            var conversion = 0.0

            if (origen == destino) {
                conversion = cantidad
            }
            else if (origen == "Euros" && destino == "Pesos") {
                conversion = cantidad * 20.43
            }
            else if (origen == "Pesos" && destino == "Euros") {
                conversion = cantidad * 0.048
            }

            else if (origen == "Euros" && destino == "Dolares") {
                conversion = cantidad * 1.10
            }
            else if (origen == "Dolares" && destino == "Euros") {
                conversion = cantidad * 0.91
            }

            else if (origen == "Euros" && destino == "Libras") {
                conversion = cantidad * 0.83
            }
            else if (origen == "Libras" && destino == "Euros") {
                conversion = cantidad * 1.20
            }

            else if(origen == "Pesos" && destino == "Dolares") {
                conversion = cantidad * 0.054
            }
            else if(origen == "Dolares" && destino == "Pesos") {
                conversion = cantidad * 18.57
            }

            else if(origen == "Pesos" && destino == "Libras") {
                conversion = cantidad * 0.041
            }
            else if(origen == "Libras" && destino == "Pesos") {
                conversion = cantidad * 24.48
            }

            else if(origen == "Dolares" && destino == "Libras") {
                conversion = cantidad * 0.76
            }
            else if(origen == "Libras" && destino == "Dolares") {
                conversion = cantidad * 1.32
            }

            resultado.text = "Resultado: " + conversion.toFloat()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbarConversor)
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
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}