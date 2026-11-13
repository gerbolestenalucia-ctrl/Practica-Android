package com.example.practicaandroid

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionlista.modelo.MarcasCoche
import com.example.practicaandroid.datosCoche.RepositorioSingleton
import com.example.practicaandroid.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

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

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recycler = findViewById<RecyclerView>(R.id.lista)
        val adaptador = AdaptadorLista(this)
        recycler.adapter = adaptador
        val layout = LinearLayoutManager(this)
        recycler.layoutManager = layout
    }
}