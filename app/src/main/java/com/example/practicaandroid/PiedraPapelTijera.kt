package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PiedraPapelTijera : AppCompatActivity() {
    //array que recorre todas las imagenes
    val imagenes = arrayOf(
        R.drawable.piedra,
        R.drawable.papel,
        R.drawable.tijera
    )

    private  lateinit var imgUsuario: ImageView
    private lateinit var imgBot: ImageView
    private lateinit var txtMensaje: TextView
    var puntosUsuario = 0
    var puntosBot = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_piedra_papel_tijera)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.atras).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        txtMensaje = findViewById(R.id.txtGanarPerder)
        imgUsuario = findViewById(R.id.imgJugador)
        imgBot = findViewById(R.id.imgBot)

        findViewById<ImageView>(R.id.imgPiedra).setOnClickListener { jugar(R.drawable.piedra) }
        findViewById<ImageView>(R.id.imgPapel).setOnClickListener { jugar(R.drawable.papel) }
        findViewById<ImageView>(R.id.imgTijera).setOnClickListener { jugar(R.drawable.tijera) }

    }
    private fun jugar(eleccionUsuario: Int) {
        //quita el texto de Elige una opción nada más pulsar el botón
        txtMensaje.text = ""

        //animación rápida
        imgBot.postDelayed({ imgBot.setImageResource(R.drawable.piedra) }, 100)
        imgBot.postDelayed({ imgBot.setImageResource(R.drawable.papel) }, 200)
        imgBot.postDelayed({ imgBot.setImageResource(R.drawable.tijera) }, 300)

        //elección final y muestra el ganador en ese mismo TextView
        imgBot.postDelayed({
            val eleccionBot = imagenes.random()
            imgUsuario.setImageResource(eleccionUsuario)
            imgBot.setImageResource(eleccionBot)

            comprobarGanador(eleccionUsuario, eleccionBot)
        }, 400)
    }

    private fun comprobarGanador(usuario: Int, bot: Int) {
        val marcadorJugador = findViewById<TextView>(R.id.marcadorJugador)
        val marcadorBot = findViewById<TextView>(R.id.marcadorBot)

        //comprobar quien gana y suma los puntos
        if (usuario == bot) {
            txtMensaje.text = "¡Empate!"
        } else if (usuario == R.drawable.piedra && bot == R.drawable.tijera) {
            txtMensaje.text = "¡Ganaste! Piedra vence a Papel"
            puntosUsuario++
            marcadorJugador.text = puntosUsuario.toString()

        } else if (usuario == R.drawable.papel && bot == R.drawable.piedra) {
            txtMensaje.text = "¡Ganaste! Papel vence a Piedra"
            puntosUsuario++
            marcadorJugador.text = puntosUsuario.toString()

        } else if (usuario == R.drawable.tijera && bot == R.drawable.papel) {
            txtMensaje.text = "¡Ganaste! Tijera vence a Papel"
            puntosUsuario++
            marcadorJugador.text = puntosUsuario.toString()

        } else {
            txtMensaje.text = "Perdiste..."
            puntosBot++
            marcadorBot.text = puntosBot.toString()
        }
    }
}