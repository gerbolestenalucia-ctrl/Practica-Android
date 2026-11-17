package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
<<<<<<< HEAD
import android.widget.ImageButton
import android.widget.ImageView
=======
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
<<<<<<< HEAD
import com.example.practicaandroid.datosCoche.ListaMarcaCoche
=======
import com.example.aplicacionlista.datos.ListaMarcaCoche
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c

class MainActivity : AppCompatActivity() {

    companion object {
        val listaCoches = ListaMarcaCoche();
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

<<<<<<< HEAD
        findViewById<Button>(R.id.irCalculadora).setOnClickListener {
            val intent = Intent(this, MainActivityCalculadora::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.irConversor).setOnClickListener {
            val intent = Intent(this, ConversorModedas::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.irJuego).setOnClickListener {
            val intent = Intent(this, PiedraPapelTijera::class.java)
            startActivity(intent)
        }

=======
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
        findViewById<Button>(R.id.irCoche).setOnClickListener {
            dialogoElegir()
        }

<<<<<<< HEAD
        findViewById<Button>(R.id.irLista).setOnClickListener {
=======
        findViewById<Button>(R.id.bLista).setOnClickListener {
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

<<<<<<< HEAD


=======
        findViewById<Button>(R.id.irCalculadora).setOnClickListener {
            val intent = Intent(this, MainActivityCalculadora::class.java)
            startActivity(intent)
        }
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
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