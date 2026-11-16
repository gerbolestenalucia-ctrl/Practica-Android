package com.example.aplicacionlista.datos

import com.example.practicaandroid.coches.modelo.MarcasCoche

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