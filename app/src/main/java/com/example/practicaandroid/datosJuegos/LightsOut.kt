package com.example.practicaandroid.datosJuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.practicaandroid.R

class LightsOut : AppCompatActivity() {

    private lateinit var botones: Array<Array<Button>>
    private lateinit var txtMovimientos: TextView
    private val tablero = Array(3) { BooleanArray(3) }
    private var movimientos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lights_out)

        val barra = findViewById<Toolbar>(R.id.toolbarLightsOut)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        txtMovimientos = findViewById(R.id.txtMovimientos)

        botones = arrayOf(
            arrayOf(
                findViewById(R.id.b1),
                findViewById(R.id.b2),
                findViewById(R.id.b3)
            ),
            arrayOf(
                findViewById(R.id.b4),
                findViewById(R.id.b5),
                findViewById(R.id.b6)
            ),
            arrayOf(
                findViewById(R.id.b7),
                findViewById(R.id.b8),
                findViewById(R.id.b9)
            )
        )

        val btnNuevaPartida = findViewById<Button>(R.id.btnNuevaPartida)
        btnNuevaPartida.setOnClickListener {
            nuevaPartida()
        }

        //recorre los botones y se asiga que hacer cuando esta pulsado
        for (fila in 0..2) {
            for (columna in 0..2) {
                botones[fila][columna].setOnClickListener {
                    pulsar(fila, columna)
                }
            }
        }
        nuevaPartida()
    }

    private fun pulsar(f: Int, c: Int) {
        movimientos++
        txtMovimientos.text = "Movimientos: $movimientos"

        //centro
        cambiar(f, c)
        //arriba
        cambiar(f - 1, c)
        //abajo
        cambiar(f + 1, c)
        //izquierda
        cambiar(f, c - 1)
        //derecha
        cambiar(f, c + 1)

        actualizarBotones()

        if (haGanado()) {
            txtMovimientos.text =
                "¡Has ganado en $movimientos movimientos!"
        }
    }

    private fun cambiar(f: Int, c: Int) {
        if (f in 0..2 && c in 0..2) {
            tablero[f][c] = !tablero[f][c]
        }
    }

    private fun actualizarBotones() {
        for (f in 0..2) {
            for (c in 0..2) {
                if (tablero[f][c]) {
                    botones[f][c].setBackgroundColor(
                        getColor(R.color.blue1)
                    )
                } else {
                    botones[f][c].setBackgroundColor(
                        getColor(R.color.blue)
                    )
                }
            }
        }
    }

    private fun nuevaPartida() {
        movimientos = 0
        txtMovimientos.text = "Movimientos: 0"

        for (f in 0..2) {
            for (c in 0..2) {
                tablero[f][c] = Math.random() < 0.5
            }
        }
        actualizarBotones()
    }

    private fun haGanado(): Boolean {
        for (f in 0..2) {
            for (c in 0..2) {
                if (!tablero[f][c]) {
                    return false
                }
            }
        }
        return true
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