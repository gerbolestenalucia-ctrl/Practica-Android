package com.example.aplicacionlista.modelo

import com.example.practicaandroid.modeloCoche.Marca

data class MarcasCoche (
    val marca: String,
    val modelo: String,
    val añoFabricacion: String,
    val numPuertas: String,
    val velocidadMaxima: String,
    val imagenMarca : Marca,
    var opinion: Int = 0
)
{
}