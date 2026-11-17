<<<<<<< HEAD
package com.example.practicaandroid.datosCoche

import com.example.aplicacionlista.datos.RepositorioMarcaCoche
=======
package com.example.aplicacionlista.datos

>>>>>>> 702674c4824ea2a07c2d91a2fb7b4910f7e01bac
import com.example.aplicacionlista.modelo.MarcasCoche

class ListaMarcaCoche : RepositorioMarcaCoche {

    val lista: MutableList<MarcasCoche> = mutableListOf();

    override fun nuevoCoche(c: MarcasCoche) {
        lista.add(c)
    }

    override fun actualizar(id: Int, c: MarcasCoche) {
        lista[id] = c
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    override fun buscar(id: Int): MarcasCoche = lista[id]

    override fun longitud(): Int {
        return lista.size
    }
}