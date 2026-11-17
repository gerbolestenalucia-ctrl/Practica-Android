package com.example.practicaandroid

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
=======
import android.os.Bundle
import android.view.View
import android.widget.Button
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaandroid.datosCalculadora.CalculadoraKt

class MainActivityCalculadora : AppCompatActivity(), View.OnClickListener {

    val calc = CalculadoraKt();

    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
<<<<<<< HEAD
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.irCoche)) { v, insets ->
=======
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        resultado = findViewById(R.id.textView)

<<<<<<< HEAD
        findViewById<ImageView>(R.id.atras).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

=======
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
        val listaBotones = listOf<Button>(
            findViewById(R.id.bClear),
            findViewById(R.id.bResta),
            findViewById(R.id.bSuma),
            findViewById(R.id.bDivision),
            findViewById(R.id.bMultiplicacion),
            findViewById(R.id.bComa),
            findViewById(R.id.bIgual),
            findViewById(R.id.bNum0),
            findViewById(R.id.bNum1),
            findViewById(R.id.bNum2),
            findViewById(R.id.bNum3),
            findViewById(R.id.bNum4),
            findViewById(R.id.bNum5),
            findViewById(R.id.bNum6),
            findViewById(R.id.bNum7),
            findViewById(R.id.bNum8),
            findViewById(R.id.bNum9),
        )

        for (i in listaBotones) i.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.bNum0 -> {
                calc.meterNumero(0)
            }

            R.id.bNum1 -> {
                calc.meterNumero(1)
            }

            R.id.bNum2 -> {
                calc.meterNumero(2)
            }

            R.id.bNum3 -> {
                calc.meterNumero(3)
            }

            R.id.bNum4 -> {
                calc.meterNumero(4)
            }

            R.id.bNum5 -> {
                calc.meterNumero(5)
            }

            R.id.bNum6 -> {
                calc.meterNumero(6)
            }

            R.id.bNum7 -> {
                calc.meterNumero(7)
            }

            R.id.bNum8 -> {
                calc.meterNumero(8)
            }

            R.id.bNum9 -> {
                calc.meterNumero(9)
            }

            R.id.bComa -> {
                calc.meterComa()
            }

            R.id.bClear -> {
                calc.clear()
            }

            R.id.bSuma -> {
                calc.operacion('+')
            }

            R.id.bResta -> {
                calc.operacion('-')
            }

            R.id.bMultiplicacion -> {
                calc.operacion('*')
            }

            R.id.bDivision -> {
                calc.operacion('/')
            }

            R.id.bIgual -> {
                calc.igual()
            }
        }
        resultado.text = calc.num2

    }
}