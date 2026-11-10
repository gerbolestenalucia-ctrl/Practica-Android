package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.MarcasCoche
import com.example.practicaandroid.modeloCoche.Marca

interface RepositorioMarcaCoche {

    fun poblar() {
        nuevoCoche(
            MarcasCoche("BMW", "M4", "2014", "3", "250km/h", Marca.BMW, 5f)
        )
        nuevoCoche(
            MarcasCoche("Audi", "A8", "1994", "5", "250km/h", Marca.AUDI, 2f)
        )
        nuevoCoche(
            MarcasCoche("Mercedes", "CLE Coupé", "2023", "3", "270km/h", Marca.MERCEDES, 4f)
        )
        nuevoCoche(
            MarcasCoche("Ferrari", "296 GTB", "2023", "3", "330km/h", Marca.FERRARI, 5f)
        )
        nuevoCoche(
            MarcasCoche("Volkswagen", "Golf GTI (8ª Generación)", "2020", "5", "250km/h", Marca.VOLKSWAGEN, 3f)
        )
        nuevoCoche(
            MarcasCoche("Ford", "Puma", "2019", "5", "220km/h", Marca.FORD, 2f)
        )
        nuevoCoche(
            MarcasCoche("Hyundai", "i20 N", "2021", "5", "230km/h", Marca.HYUNDAI, 4f)
        )
        nuevoCoche(
            MarcasCoche("Toyota", "GR Supra", "2020", "3", "250km/h", Marca.TOYOTA, 5f)
        )
        nuevoCoche(
            MarcasCoche("Porsche", "911 Carrera", "2022", "3", "293km/h", Marca.PORSCHE, 3f)
        )
        nuevoCoche(
            MarcasCoche("Lamborghini", "Huracán EVO", "2021", "2", "325km/h", Marca.LAMBORGHINI, 5f)
        )
        nuevoCoche(
            MarcasCoche("Renault", "Clio RS", "2018", "5", "240km/h", Marca.RENAULT, 2f)
        )
        nuevoCoche(
            MarcasCoche("Seat", "León Cupra", "2021", "5", "250km/h", Marca.SEAT, 4f)
        )
    }

    fun nuevoCoche(c: MarcasCoche)
    fun actualizar(id: Int, c: MarcasCoche)
    fun borrar(id: Int)
    fun buscar(id: Int): MarcasCoche
    fun longitud(): Int

}