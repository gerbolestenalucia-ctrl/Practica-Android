package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListaNuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_nuevo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            val marca1 = findViewById<EditText>(R.id.textMarca).text.toString()
            val modelo1 = findViewById<EditText>(R.id.textModelo).text.toString()
            val anio1 = findViewById<EditText>(R.id.textAnio).text.toString()
            val numPuertas1 = findViewById<EditText>(R.id.textPuertas).text.toString().toInt()
            val maxVelocidad1 = findViewById<EditText>(R.id.textVelocidad).text.toString().toInt()


            intent.putExtra("marca", marca1)
            intent.putExtra("modelo", modelo1)
            intent.putExtra("anio", anio1)
            intent.putExtra("numeroPuertas", numPuertas1)
            intent.putExtra("velocidad_maxima", maxVelocidad1)

            startActivity(intent);
        }



    }
}