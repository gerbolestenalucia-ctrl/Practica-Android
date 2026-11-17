package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
=======
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
=======
import com.example.aplicacionlista.modelo.MarcasCoche
import com.example.practicaandroid.datosCoche.RepositorioSingleton
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
import com.example.practicaandroid.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

<<<<<<< HEAD
        val lista = ArrayList<String>();
=======
        fun dialogoNuevo() {
            val entrada = EditText(this)
            entrada.inputType = InputType.TYPE_CLASS_NUMBER
            entrada.hint = "Numero de coches"
            AlertDialog.Builder(this)
                .setTitle("Introduce un nuevo coche")
                .setTitle("Introduce un numero para añadir coches")
                .setView(entrada)
                .setPositiveButton("Nuevo") { dialog, whichButton ->
                    val num = entrada.text.toString().toInt()
                    val intent = Intent(this, EditarCocheActivity::class.java)
                    intent.putExtra("numero coche", num)
                    intent.putExtra("opcion", "nuevo")
                    startActivity(intent)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        findViewById<ImageView>(R.id.iconoMas).setOnClickListener {
            dialogoNuevo()
        }


        fun dialogoEditar() {
            val entrada = EditText(this)
            entrada.inputType = InputType.TYPE_CLASS_NUMBER
            entrada.hint = "Numero de coches"
            AlertDialog.Builder(this)
                .setTitle("Editar un coche")
                .setTitle("Introduce un numero para editar el coche")
                .setView(entrada)
                .setPositiveButton("Editar") { dialog, whichButton ->
                    val num = entrada.text.toString().toInt()
                    val intent = Intent(this, EditarCocheActivity::class.java)
                    intent.putExtra("numero coche", num)
                    intent.putExtra("opcion", "editar")
                    startActivity(intent)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        findViewById<ImageView>(R.id.iconoEditar).setOnClickListener {
            dialogoEditar()
        }

        fun dialogoEliminar() {
            val entrada = EditText(this)
            entrada.inputType = InputType.TYPE_CLASS_NUMBER
            entrada.hint = "Numero de coches"
            AlertDialog.Builder(this)
                .setTitle("Eliminar un coche")
                .setTitle("Introduce un numero para eliminar el coche")
                .setView(entrada)
                .setPositiveButton("Eliminar") { dialog, whichButton ->
                    val num = entrada.text.toString().toInt()
                    RepositorioSingleton.instance.listaCoches.borrar(num)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        findViewById<ImageView>(R.id.iconoEliminar).setOnClickListener {
            dialogoEliminar();
        }
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

<<<<<<< HEAD
        findViewById<ImageView>(R.id.nuevo).setOnClickListener {
            val intent = Intent(this, ListaNuevo::class.java)
            startActivity(intent)
        }

=======
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
<<<<<<< HEAD

        val marca = intent.getStringExtra("marca")
        val modelo = intent.getStringExtra("modelo")
        val anio = intent.getStringExtra("anio")
        val puertas = intent.getIntExtra("numeroPuertas", 0)
        val velocidad = intent.getIntExtra("velocidad_maxima", 0)

        val coche = "$marca - $modelo - $anio - $puertas puertas - $velocidad km/h"
        lista.add(coche)

=======
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
        val recycler = findViewById<RecyclerView>(R.id.lista)
        val adaptador = AdaptadorLista(this)
        recycler.adapter = adaptador
        val layout = LinearLayoutManager(this)
        recycler.layoutManager = layout
<<<<<<< HEAD


=======
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
    }
}