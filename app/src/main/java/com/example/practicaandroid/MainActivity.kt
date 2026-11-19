package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.ListaMarcaCoche
import com.example.practicaandroid.coches.CocheActivity
import com.example.practicaandroid.coches.ListaActivity
import com.example.practicaandroid.datosCalculadora.CalculadoraActivity
import com.example.practicaandroid.datosConversor.ConversorMonedaActivity
import com.example.practicaandroid.datosJuegos.JuegosActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val listaCoches = ListaMarcaCoche()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.irLista).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irCalculadora).setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irConversor).setOnClickListener {
            val intent = Intent(this, ConversorMonedaActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.irJuegos).setOnClickListener {
            val intent = Intent(this, JuegosActivity::class.java)
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
                val intent = Intent(this, CocheActivity::class.java)
                intent.putExtra("numero coche", num)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}