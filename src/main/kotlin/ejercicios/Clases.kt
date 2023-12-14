package com.cursosdedesarrollo.kotlin.ejercicios

fun main() {
    val indra = Cliente()
    indra.setCotizacion(10F)
    println(indra.getCotizacion())
    println(indra.getTotalCotizaciones())
    println(indra)

    val jcyl = Cliente(
        "Junta",
        "Valladolid",
        "983 327 850",
        "area.dg.tyad@jcyl.es")
    println(jcyl)
}