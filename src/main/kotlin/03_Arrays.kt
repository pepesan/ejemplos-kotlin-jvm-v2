package com.cursosdedesarrollo.kotlin


fun main(args: Array<String>) {
    val x: IntArray = intArrayOf(1, 2, 3)
    // puedo cambiar la variable (por dentro) aunque sea val
    x[0] = x[1] + x[2]
    println(x[0])
    // no puedo redeclarar la variable
    // x = intArrayOf(1, 2, 3)
    println(x.get(0))
    x.set(0,2)
    println(x.get(0))
    print("Tamaño:")
    println(x.size)

    /*
    El array es estático en tamaño
    No puedo acceder al índice 3
    x[3]= 2
    println(x[3])
    */

    println("Contiene el 2? ${x.contains(2)}")

    println("Está vacío? ${x.isEmpty()}")




    // Creates an Array<String> with values ["0", "1", "4", "9", "16"]
    var asc = Array(5, { x -> (x * x).toString() })

    var arrI = Array(5, { i -> i })

    //inicialización a 0
    arrI= Array(5, {0})

    arrI = Array(5) {0}

    for (item in arrI){
        println(item)
    }

    for (i in 0..<arrI.size){
        val item = arrI[i]
        println("$i  = $item" )
    }

    for (i in arrI.indices){
        val item = arrI[i]
        println("$i  = $item" )
    }


    val arrI2 = Array(4) {i -> i + 1.0}
    for (item in arrI2){
        println(item)
    }


}
