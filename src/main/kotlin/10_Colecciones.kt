package com.cursosdedesarrollo.kotlin

import kotlin.math.cos
import java.util.HashSet


// Ejemplo de programación funcional
fun main(args : Array<String>) {
    val cosas = listOf(1, "", 3, 4, 5)
    //cosas = listOf(1, "", 3, 4, 5) inmutable no se puede cambiar
    for (cosa in cosas) {
        println(cosa)
        if(cosa==3){

        }
    }
    //declaramos un listado y lo rellenamos con listOf
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }
    var names: List<String> = listOf("Chike", "Nnamdi", "Mgbemena")
    for (name in names) {
        println(name)
    }
    println(names.size) // tamaño
    println(names.get(0)) // Primer elemento
    println(names.indexOf("Chike")) // posición
    println(names.contains("Chike")) //  presencia

    //convertimos de inmutable a mutable
    val mutables = names.toMutableList()
    mutables.add("Ruth") // ahora podemos añadir
    // mutables = names.toMutableList() es inmutable no la puedo reasginar
    // pero como el listado es mutable lo puedo modificar
    val emptyList: List<String> = emptyList<String>()

    println("Listado Vacío")
    for (name in emptyList) {
        println(name)
    }

    val mutableListNames: MutableList<String> = mutableListOf<String>("Josh", "Kene", "Sanya")

    mutableListNames.add("Mary")
    mutableListNames.removeAt(1)
    mutableListNames[0] = "Oluchi" //  Cambia el primero
    // listado mutable hererogéneo
    val mutableListMixed = mutableListOf("BMW", "Toyota", 1, 6.76, 'v')

    val mutableListFood: MutableList<String> = mutableListOf<String>("Rice & stew", "Jollof rice", "Eba & Egusi", "Fried rice")
    mutableListFood.remove("Fried rice")
    mutableListFood.removeAt(0)
    mutableListFood.set(0, "Beans")
    mutableListFood.add(1, "Bread & tea")

    for (foodName in mutableListFood) {
        println(foodName)
    }


    // crea un set inmutable
    val mixedTypesSet = setOf(2, 4.454, "how", "far", 'c')
    // sólo de enteros
    var intSet: Set<Int> = setOf(1, 3, 4)

    // HashSet es mutable
    val intsHashSet = hashSetOf(1, 2, 6, 3)
    intsHashSet.add(5)
    intsHashSet.remove(1)

    // El TreeSet está Ordenado
    val intsSortedSet: java.util.TreeSet<Int>  = sortedSetOf(4, 1, 7, 2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    intsSortedSet.clear()


    // Crea un Set mutable
    val intsMutableSet: MutableSet<Int> = mutableSetOf(3, 5, 6, 2, 0)
    intsMutableSet.add(8)
    intsMutableSet.remove(3)


    // Mapa de clave entera y valor string
    val callingCodesMap: Map<Int, String> = mapOf(234 to "Nigeria", 1 to "USA", 233 to "Ghana")
    for ((key, value) in callingCodesMap) {
        println("$key is the calling code for $value")
    }
    print(callingCodesMap[234]) // Nigeria

    val currenciesMutableMap: MutableMap<String, String> = mutableMapOf("Naira" to "Nigeria", "Dollars" to "USA", "Pounds" to "UK")
    println("Countries are ${currenciesMutableMap.values}") // Countries are [Nigeria, USA, UK]
    println("Currencies are ${currenciesMutableMap.keys}") // Currencies are [Naira, Dollars, Pounds]
    currenciesMutableMap.put("Cedi", "Ghana")
    currenciesMutableMap.remove("Dollars")
}