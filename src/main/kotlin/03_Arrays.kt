package com.cursosdedesarrollo.kotlin


fun main(args: Array<String>) {
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    println(x[0])
    println(x.get(0))
    x.set(0,2)
    println(x.get(0))
    print("Tamaño:")
    println(x.size)

    /*
    x[4]= 2
    println(x[4])
    */

    println("Contiene el 2? ${x.contains(2)}")


    // Creates an Array<String> with values ["0", "1", "4", "9", "16"]
    var asc = Array(5, { i -> (i * i).toString() })

    var arrI = Array(5, { i -> i })

    //inicialización a 0
    arrI= Array(5, {0})

    for (item in arrI){
        println(item)
    }

    val arrI2 = Array(4) {i -> i + 1.0}
    for (item in arrI2){
        println(item)
    }

}
