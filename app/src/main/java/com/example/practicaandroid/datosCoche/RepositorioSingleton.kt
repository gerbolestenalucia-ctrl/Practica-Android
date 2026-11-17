package com.example.practicaandroid.datosCoche

<<<<<<< HEAD
import com.example.aplicacionlista.datos.RepositorioMarcaCoche


=======
import com.example.aplicacionlista.datos.ListaMarcaCoche
import com.example.aplicacionlista.datos.RepositorioMarcaCoche

>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
class RepositorioSingleton private constructor() {

    companion object {
        val instance = RepositorioSingleton()
    }
    val listaCoches : RepositorioMarcaCoche = ListaMarcaCoche();

    init {
        listaCoches.poblar()
    }

}