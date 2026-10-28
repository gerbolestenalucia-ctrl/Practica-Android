package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.MarcasCoche

interface RepositorioMarcaCoche {

    fun poblar() {
        nuevoCoche(
            MarcasCoche("BMW", "M4", "2014", "3", "250km/h")
        )
        nuevoCoche(
            MarcasCoche("Audi", "A8", "1994", "5", "250km/h")
        )
        nuevoCoche(
            MarcasCoche("Mercedes", "CLE Coupé", "2023", "5", "270km/h")
        )
        nuevoCoche(
            MarcasCoche("Ferrari", "296 GTB", "2023", "3", "330km/h")
        )
        nuevoCoche(
            MarcasCoche("Volkswagen", "Golf GTI (8ª Generación)", "2020", "5", "250km/h")
        )
        nuevoCoche(
            MarcasCoche("Ford", "Puma", "2019", "5", "220km/h")
        )
        nuevoCoche(
            MarcasCoche("Hyundai", "i20 N", "2021", "5", "230km/h")
        )


    }

    fun nuevoCoche(c: MarcasCoche)
    fun actualizar(id: Int, c: MarcasCoche)
    fun borrar(id: Int)
    fun buscar(id: Int): MarcasCoche
    fun longitud(): Int

}