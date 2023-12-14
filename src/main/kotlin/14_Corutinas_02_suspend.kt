package com.cursosdedesarrollo.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Función suspendida
suspend fun realizarOperacionAsincrona() {
    println("Iniciando operación asíncrona")
    delay(1000) // Simular una operación asíncrona que toma 1 segundo
    println("Operación asíncrona completada después de 1 segundo")
}

fun main() = runBlocking {
    // Lanzar una corutina para ejecutar la función suspendida
    launch {
        realizarOperacionAsincrona()
    }

    // Hacer otras cosas en el hilo principal mientras la corutina está en curso
    println("Hilo principal: Continuando con otras tareas")

    // Esperar a que la corutina termine (solo con fines de demostración, en un entorno de producción deberías gestionar mejor la sincronización)
    delay(2000)
}
