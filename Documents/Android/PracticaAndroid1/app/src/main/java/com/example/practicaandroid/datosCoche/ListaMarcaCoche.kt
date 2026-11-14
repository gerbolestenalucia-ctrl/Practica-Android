<<<<<<< HEAD
package com.example.practicaandroid.datosCoche

import com.example.practicaandroid.modeloCoche.MarcasCoche
=======
package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.MarcasCoche
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c

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