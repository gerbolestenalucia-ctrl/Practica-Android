package com.example.practicaandroid.datosJuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R

class JuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)

        findViewById<ImageView>(R.id.irJuegoPPT).setOnClickListener {
            val intent = Intent(this, PiedraPapelTijera::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irJuegoDado).setOnClickListener {
            val intent = Intent(this, Dados::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbarJuegos)
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