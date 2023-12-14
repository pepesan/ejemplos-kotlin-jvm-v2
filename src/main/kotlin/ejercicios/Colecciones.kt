package com.cursosdedesarrollo.kotlin.ejercicios

fun main() {
    var listado =  mutableListOf<Int>()
    for (i in 1..50) {
        listado.add(i)
    }

    listado = MutableList(50) {i -> i + 1}
    println(listado)

    val cliente: MutableMap<String, Any> = mutableMapOf(
        "nombre" to "David",
        "direccion" to "Calle falsa 123",
        "tlf" to "123456789",
        "email" to "p@p.com"
    )
    println(cliente)

    val numeros = setOf(1,2)

    // presenta los datos

    presentaListado(listado)

    for (item in cliente){
        println(item.key + " " + item.value)
    }

    presentaConjunto(numeros)

    // añade tres elementos al final de la lista
    listado.addAll(listOf(51,52,53))
    // o
    for (i in 1..4){
        listado.add(i)
    }
    println(listado)

    // añade un elemento al mapa
    cliente["facturacion_total"] = 1000

    presentaListado(listado)
    presentaConjunto(numeros)

    val listaSencilla = listOf(1,2,3)
    for (item in listaSencilla){
        listado.add(item+15)
    }
}

private fun presentaConjunto(numeros: Set<Int>) {
    for (item in numeros) {
        println(item)
    }
}

private fun presentaListado(listado: MutableList<Int>) {
    for (item in listado) {
        println(item)
    }
}