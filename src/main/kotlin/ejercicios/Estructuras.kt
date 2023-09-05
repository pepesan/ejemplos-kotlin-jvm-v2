package com.cursosdedesarrollo.kotlin.ejercicios

import java.util.*

// Ejercicio 2
fun countLetters(str: String): Int {

    var letterCount = 0


    for (item in str){
        letterCount++
    }

    letterCount = 0
    for ((i, c) in str.withIndex() ){
//            if (!c.isWhitespace()) {
//                println("The letter $c appears ${str.count{it == c}} times.")
        letterCount++
        //}
    }

    return letterCount
}

// Ejercicio 3
fun searchWordInString(str: String, wordToSearch: String): Boolean {
    val lowercaseStr = str.lowercase(Locale.getDefault())
    val lowercaseWordToSearch = wordToSearch.lowercase(Locale.getDefault())
    return lowercaseStr.contains(lowercaseWordToSearch)
}

// Ejercicio 4
fun createArrayWithValues(sizeOfArray: Int, valueToFillArray: Int): Array<Int> {
    val myArray = Array(sizeOfArray) { valueToFillArray }
    return myArray
}

// Ejercicio 5
fun printElementsFromArray(myArray: Array<Int>): Unit {
    for ((index, item) in myArray.withIndex()) {
        println("Element at index $index is $item")
    }
}
// Ejercicio 6
fun modifyFourthValueAndPrintIt(myArray: Array<Int>, newValueForFourthPosition: Int): Unit {
    myArray[3] = newValueForFourthPosition
    println("New fourth value is ${myArray[3]}")
}


fun main() {
    // Ejercicio 1
    val longString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    // Ejercicio 2
    println(countLetters(longString))
    // Ejercicio 3
    println(searchWordInString(longString, "ipsum"))
    // Ejercicio 4
    val miArray = createArrayWithValues(5, 0)
    // Ejercicio 5
    println(miArray)
    //Ejercicio 6
    modifyFourthValueAndPrintIt(miArray,4)
}
