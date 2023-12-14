package com.cursosdedesarrollo.kotlin


fun main(args : Array<String>) {
    var s = "Hello, world!\n"
    println(s)

    s = "abc" + 1
    println(s)

    s = """
    for (c in "foo")
        print(c)
    """
    println(s)
    println("TrimMargin")
    s = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(s)

    val i = 10
    println("i = $i") // prints "i = 10"

    s = "abc"
    println("$s.length is ${s.length}") // prints "abc.length is 3"

    var x="Hola"
    if(x is String){
        println(x.length)
    }

    val myString = """
    !!! Kotlin es interesante.
    !!! Kotlin ha sido desarrollador por JetBrains.
    """
    println(myString.trimMargin("!!! "))

    val s1  = "Hey there!"
    val s2 = "Hey there!"
    var result: String

    println("Length of s1 string is ${s1.length}.")

    result = if (s1.compareTo(s2) == 0) "equal" else "not equal"
    println("Strings s1 and s2 are $result.")

    // s1.get(2) is equivalent to s1[2]
    println("Third character is ${s1.get(2)}.")

    result = s1.plus(" How are you?") // result = s1 + " How are you?"
    println("result = $result")
    // val s1  = "Hey there!"
    println("Substring is \"${s1.subSequence(4, 7)}\"")

}
