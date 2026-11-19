package com.example.practicaandroid.coches

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaandroid.MainActivity
import com.example.practicaandroid.R
import com.example.practicaandroid.coches.CocheActivity.Companion.NUMERO_COCHES
import com.example.practicaandroid.coches.datos.RepositorioSingleton
import com.example.practicaandroid.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {

    var idCoche: Int = -1
    private val adaptador = AdaptadorLista.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idCoche = intent.extras?.getInt(NUMERO_COCHES) ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbarLista)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val recycler = findViewById<RecyclerView>(R.id.lista)
        recycler.adapter = adaptador
        val layout = LinearLayoutManager(this)
        recycler.layoutManager = layout
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_crear_salir, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idBoton = item.itemId
        return when (idBoton) {
            R.id.añadirNuevo -> {
                val intent = Intent(this, EditarCocheActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.añadirSalir -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        findViewById<RecyclerView>(R.id.lista).adapter?.notifyDataSetChanged()
        super.onResume()
    }
}