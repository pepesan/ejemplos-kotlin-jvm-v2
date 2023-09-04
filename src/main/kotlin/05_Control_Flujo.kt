package com.cursosdedesarrollo.kotlin

import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.Integer.parseInt

fun main(args : Array<String>) {
    var a=1
    var b=2
    var max = a
    if (a < b) max = b

    // With else

    if (a > b) {
        max = a
    } else {
        max = b
    }

    // As expression
    max = if (a > b) a else b
    println(max)


    max = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
    println(max)

    var x=1
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // Note the block
            println("x is neither 1 nor 2")
        }
    }


    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }
    println("Parse Int")
    println("X:"+x)
    var s="1"
    x=2
    when (x) {
        parseInt(s) -> println("s encodes x")
        else -> println("s does not encode x")
    }

    var validNumbers: Array<Int> = arrayOf(1,2,3,4)
    when (x) {
        in 1..10 -> println("x is in the range")
        in validNumbers -> println("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    var devuelto =hasPrefix(s)
    println(devuelto)

    var collection: Array<String> = arrayOf("1","2","3")
    println("Colección")
    for (item in collection) {
        println(item)
    }

    //números del 0 al 8 step 2
    val arrayNumeros = Array(5, { i -> i * 2 })
    for (item in arrayNumeros) {
        println(item)
    }
    for (i in 1..3) {
        println(i)
    }

    // Manejo de tuplas

    val items = listOf(1, 22, 83, 4)

    for ((indice, valor) in items.withIndex()) {
        println("$indice con valor $valor")
    }
    //for ( var i = 6; i>=0 ; i-2){
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    for (i in collection.indices) {
        println(collection[i])
    }
    bucle1@ for (i in 1..10) {
        bucle2@for (j in 1..10) {
            println("i: $i, j:$j : ${i+j}")
            if (i>5 && j>4) break@bucle1

        }
    }

    x=2
    while (x > 0) {
        x--
        println(x)
    }
    x=2
    do {
        println(x)
        x--
    } while (x >=0) // y is visible here!


    try {
        val entero:Int = 12;
        val v:String = "Mi cadena molona";
        v.toInt();
    }catch(e:NullPointerException) {
        println("Lo que hago si peta por null")
        e.printStackTrace();
    }catch(e:NumberFormatException) {
        println("Lo que hago si peta por fallo de conversión")
        e.printStackTrace();
    }catch(e:Exception) {
        println("Lo que hago si peta por que sí")
        e.printStackTrace();
    } finally {
        println("Esto lo hacemos igualmente");
    }
    println("El siguiente código a la excepción se ejecuta")
}