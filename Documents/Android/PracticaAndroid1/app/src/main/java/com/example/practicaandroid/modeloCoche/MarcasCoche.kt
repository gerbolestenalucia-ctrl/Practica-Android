<<<<<<< HEAD
package com.example.practicaandroid.modeloCoche;
=======
package com.example.aplicacionlista.modelo

import com.example.practicaandroid.modeloCoche.Marca
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c

data class MarcasCoche (
    val marca: String,
    val modelo: String,
<<<<<<< HEAD
    val añoFabricacion: String,
    val numPuertas: String,
=======
    val añoFabricacion: Int,
    val numPuertas: Int,
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
    val velocidadMaxima: String,
    val imagenMarca : Marca,
    var opinion: Float = 0f
)
{
}