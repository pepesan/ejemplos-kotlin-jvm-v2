package com.cursosdedesarrollo.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun funcionUno(): String {
    delay(1000) // Simular una operación que toma 1 segundo
    return "Resultado de la función uno"
}

suspend fun funcionDos(): String {
    delay(1500) // Simular una operación que toma 1.5 segundos
    return "Resultado de la función dos"
}

fun main() = runBlocking {
    // Lanzar ambas funciones de manera paralela
    val resultadoUno = async { funcionUno() }
    val resultadoDos = async { funcionDos() }

    // Esperar a que ambas funciones completen
    val resultadoFinalUno = resultadoUno.await()
    val resultadoFinalDos = resultadoDos.await()

    // Imprimir los resultados
    println("Resultado Uno: $resultadoFinalUno")
    println("Resultado Dos: $resultadoFinalDos")
}

