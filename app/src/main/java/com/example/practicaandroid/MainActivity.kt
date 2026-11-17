package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.datosCoche.ListaMarcaCoche
import com.example.practicaandroid.datosConversor.ConversorMoneda
import com.example.practicaandroid.datosDado.JuegoDado

class MainActivity : AppCompatActivity() {

    companion object {
        val listaCoches = ListaMarcaCoche();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.irCoche).setOnClickListener {
            dialogoElegir()
        }

        findViewById<ImageView>(R.id.irLista).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irCalculadora).setOnClickListener {
            val intent = Intent(this, MainActivityCalculadora::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irConversor).setOnClickListener {
            val intent = Intent(this, ConversorMoneda::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irJuegoPPT).setOnClickListener {
            val intent = Intent(this, PiedraPapelTijera::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irJuegoDado).setOnClickListener {
            val intent = Intent(this, JuegoDado::class.java)
            startActivity(intent)
        }


    }
    fun dialogoElegir(){
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        entrada.hint = "Numero de coches"
        AlertDialog.Builder(this)
            .setTitle("Elige un coche")
            .setTitle("Introduce un numero para elegir el coche")
            .setView(entrada)
            .setPositiveButton("Buscar") { dialog, whichButton ->
                val num = entrada.text.toString().toInt()
                //val cocheSeleccionado = listaCoches.buscar(num)
                //Log.d("COCHE LOG", cocheSeleccionado.marca)
                val intent = Intent(this, CocheActivity::class.java)
                intent.putExtra("numero coche", num)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}