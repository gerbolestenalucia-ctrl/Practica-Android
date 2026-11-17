package com.example.aplicacionlista.modelo

import com.example.practicaandroid.modeloCoche.Marca

data class MarcasCoche (
    var marca: String,
    var modelo: String,
    var añoFabricacion: Int,
    var numPuertas: Int,
    var velocidadMaxima: String,
    var imagenMarca : Marca,
    var opinion: Float = 0f
)
{
}