package com.example.aplicacionlista.modelo

data class MarcasCoche (
    val marca: String,
    val modelo: String,
    val añoFabricacion: String,
    val numPuertas: String,
    val velocidadMaxima: String,
    var opinion: Int = 0
)
{
}