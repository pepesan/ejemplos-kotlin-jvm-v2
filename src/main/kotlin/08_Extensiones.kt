package com.cursosdedesarrollo.kotlin

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args : Array<String>) {
    var listado:MutableList<Int> = mutableListOf(1, 2, 3)
    println(listado)
    listado.swap(0,1)
    println(listado)
}