package com.cursosdedesarrollo.kotlin

fun main(args : Array<String>) {
    // no tiene mucho sentido un val que sea nullable
    val inmutable: Int? = null
    // inmutable = 3
    println(inmutable?.toLong())

    var nulable: Int?=null
    println(nulable?.toString())
    nulable=2
    println(nulable)

    // acceso a valor con !! devuelve tipo sin ser nullable
    val b : String? = "Hola"
    val l: Int = b!!.length
    val l2: Int? = b?.length
}