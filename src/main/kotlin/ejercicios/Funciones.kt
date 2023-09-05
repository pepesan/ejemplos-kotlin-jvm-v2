package com.cursosdedesarrollo.kotlin.ejercicios

fun cuenta(i1: Int, i2: Int): Unit{
    val res = i1+i2
    println(res)
}
fun divide(i1: Int = 1, i2: Int = 1): Float{
    return (i1/i2).toFloat()
}
fun divideFloat(i1: Int = 1, i2: Int = 1): Float{
    return i1.toFloat()/i2.toFloat()
}
fun main() {
    cuenta(1,2)
    var resultado = divide(2,2)
    println(resultado)
    resultado = divideFloat(8,3)
    println(resultado)
}