package com.example.practicaandroid.datosConversor

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
=======
import android.os.Bundle
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
<<<<<<< HEAD
import com.example.practicaandroid.MainActivity
=======
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
import com.example.practicaandroid.R

class ConversorMoneda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor_moneda)
<<<<<<< HEAD

        findViewById<ImageView>(R.id.atras).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val editText = findViewById<EditText>(R.id.editTextNumber)
        val spinnerOrigen = findViewById<Spinner>(R.id.spinner3)
        val spinnerDestino = findViewById<Spinner>(R.id.spinner4)
        val boton = findViewById<Button>(R.id.buttonConvertir)
        val resultado = findViewById<TextView>(R.id.textViewResultado)

        val monedas = arrayOf(
            "Euros",
            "Pesos",
            "Dolares",
            "Libras"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            monedas
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )

        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter

        boton.setOnClickListener {

            val cantidad = editText.text.toString().toDouble()

            val origen = spinnerOrigen.selectedItem.toString()
            val destino = spinnerDestino.selectedItem.toString()

            var conversion = 0.0

            if (origen == destino) {
                conversion = cantidad
            }
            else if (origen == "Euros" && destino == "Pesos") {
                conversion = cantidad * 20.43
            }
            else if (origen == "Pesos" && destino == "Euros") {
                conversion = cantidad * 0.048
            }

            else if (origen == "Euros" && destino == "Dolares") {
                conversion = cantidad * 1.10
            }
            else if (origen == "Dolares" && destino == "Euros") {
                conversion = cantidad * 0.91
            }

            else if (origen == "Euros" && destino == "Libras") {
                conversion = cantidad * 0.83
            }
            else if (origen == "Libras" && destino == "Euros") {
                conversion = cantidad * 1.20
            }

            resultado.text = "Resultado: " + conversion.toFloat()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
=======
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}