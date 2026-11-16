package com.example.practicaandroid.coches.modelo

data class MarcasCoche (
    val marca: String,
    val modelo: String,
    val añoFabricacion: Int,
    val numPuertas: Int,
    val velocidadMaxima: String,
    val imagenMarca : Marca,
    var opinion: Float = 0f
)
{
}