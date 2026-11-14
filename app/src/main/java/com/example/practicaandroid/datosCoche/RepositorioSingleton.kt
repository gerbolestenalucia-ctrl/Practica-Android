package com.example.practicaandroid.datosCoche

import com.example.aplicacionlista.datos.ListaMarcaCoche
import com.example.aplicacionlista.datos.RepositorioMarcaCoche

class RepositorioSingleton private constructor() {

    companion object {
        val instance = RepositorioSingleton()
    }
    val listaCoches : RepositorioMarcaCoche = ListaMarcaCoche();

    init {
        listaCoches.poblar()
    }

}