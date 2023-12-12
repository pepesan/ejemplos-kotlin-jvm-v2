package com.cursosdedesarrollo.kotlin

// definición de constante global
const val PI = 3.14159
fun main(args : Array<String>) {
    // Integer oneMillion = 1000000;
    val oneMillion = 1_000_000
    // Es inmutable no puedo -> oneMillion = 2
    // Long creditCardNumber = 1234567890123456L;
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println(oneMillion)
    println(creditCardNumber)
    println(socialSecurityNumber)
    println(hexBytes)
    println(bytes)

    val fecha = "29th March, 1709"
    // fecha = "25th December, 1600" // no puede cambiar

    var coche = "Toyota Matrix"
    coche = "Mercedes-Maybach" // puede cambiar


    var edad = 12
    // edad = "12 años" // Error: no puede cambiar de tipo

    val a: Int
    a = 10000

    // usa el Integer de Java
    var numero: Integer


    println(a === a) // Prints 'true'
    val boxedA: Int = a
    val anotherBoxedA: Int = a
    println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
    println(boxedA == anotherBoxedA) // Prints 'true'
    // Hypothetical code, does not actually compile:
    val a2: Int = 1 // A boxed Int (java.lang.Integer)
    val b2: Long = 0L + a2 // conversión explícita de variable
    //casting
    println(a2.toLong() == b2) // Surprise! This prints "false" as Long's equals() check for other part to be Long as well


    val miInt = 55
    val miLong = 40L
    val miFloat = 34.43F
    val miDouble = 45.78
    val miHexadecimal = 0x0F
    val miBinario = 0b010101


    val miInt3: Int = 987
    val miLong2 = miInt3.toLong()
    val cadena2 = "101"
    val miInt2 = cadena2.toInt()

    val miTrue: Boolean = true
    val miFalse = false

    val miString = "This is a String"
    val stringEscapada = "This is a string with new line \n"

    val stringMultiLinea = """





        $miString
        Primera línea
        Segunda
        Tercera """
    println("Cadena larga:"+stringMultiLinea)

    val miJSON= """
       {
           "name": "$miString",
           "age": $miInt2,
       } 
    """
    println(miJSON)
    //concatenación o llenado de cadenas
    val balance = 200
    val mensaje = "El balance es de $balance"
    //mensaje = "El balance es de \$balance"
    println(mensaje)
    //acceso a métodos de un objeto
    val nombre = "Carlos"
    val mensaje2 =
        "La primera letra del nombre es ${nombre.first()}"
    println(mensaje2)
    val b4: Byte = 1 // OK, literals are checked statically
    //val i: Int = b4 // ERROR
    val i: Int = b4.toInt() // OK: explicitly widened

    //variables nullables
    val a3: String = "abc"
    //a = null // compilation error
    //declaro una variable nullable
    var b3: String? = "abc"
    b3 = null // ok
    println("b3 vale ${b3?.length}")

    // cuentas con nullables

    var entero1 = 2;
    var entero2: Int? = 0;
    // entero2 = null
    var resultado = entero1 + entero2!!

    var cadena: String? = "hola"
    cadena = null
    println("cadena vale ${cadena?.length}")


    //intento acceder a un valor sabiendo que debe existir
    val l = a3.length
    println(l)
    //accedo a un valor nullable intentando capturar el valor de la vairable si existe
    //val l2 = b3?.length ?:-1
    if(b3!=null){
        var l2=b3?.length
    }else{
        var l2=-1
    }
    val l2 = b3?.length
    println("Valor nullable:"+l2)

    var miEntero: Int = 2
    val unSupuesto: Int? = miEntero as? Int
    var largo: Long? = miEntero.toLong()
    // var largo: Long? = miEntero as? Long
    println("entero vale $largo")

    var obj:String= "Hola"
    if (obj is String) {
        println(obj.length)
    }
    /*
    var obj2:Int=2

    if (obj2 !is String) { // same as !(obj is String)
        println("Not a String")
    }
    else {
        println(obj2.length)
    }

    Averiguar porque no hay casting automatico
    var x: Int=1
    if (x is String) {
        print(x.length) // x is automatically cast to String
    }
    */

    println(b3?.length)
    b3=null
    if (b3 != null) {
        println(b3.length)
    }
    //println(b3!!.length)

    val b5 = b3

}