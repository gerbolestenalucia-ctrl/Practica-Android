package com.example.practicaandroid.datosCoche

<<<<<<< HEAD
=======
import com.example.aplicacionlista.datos.ListaMarcaCoche
import com.example.aplicacionlista.datos.RepositorioMarcaCoche

>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
class RepositorioSingleton private constructor() {

    companion object {
        val instance = RepositorioSingleton()
    }
    val listaCoches : RepositorioMarcaCoche = ListaMarcaCoche();

    init {
        listaCoches.poblar()
    }

}