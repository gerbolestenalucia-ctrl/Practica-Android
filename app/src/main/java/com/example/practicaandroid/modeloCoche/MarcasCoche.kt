package com.example.aplicacionlista.modelo

import com.example.practicaandroid.modeloCoche.Marca

data class MarcasCoche (
<<<<<<< HEAD
    var marca: String,
    var modelo: String,
    var añoFabricacion: Int,
    var numPuertas: Int,
    var velocidadMaxima: String,
    var imagenMarca : Marca,
=======
    val marca: String,
    val modelo: String,
    val añoFabricacion: Int,
    val numPuertas: Int,
    val velocidadMaxima: String,
    val imagenMarca : Marca,
>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
    var opinion: Float = 0f
)
{
}