package com.cursosdedesarrollo.kotlin

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

suspend fun tarea(id: Int) {
    println("Tarea $id comenzada en el hilo: ${Thread.currentThread().name}")
    // Simular alguna operación
    kotlinx.coroutines.delay(1000)
    println("Tarea $id completada en el hilo: ${Thread.currentThread().name}")
}

fun main() = runBlocking {
    // Crear un pool de 10 hilos
    val pool = Executors.newFixedThreadPool(10)
    val poolContext = pool.asCoroutineDispatcher()

    // Ejecutar varias corutinas en paralelo utilizando el pool de hilos
    val coroutines = List(10) { id ->
        launch(poolContext) {
            tarea(id)
        }
    }

    // Esperar a que todas las corutinas completen
    coroutines.forEach { it.join() }

    // Cerrar el pool de hilos cuando hayas terminado
    pool.shutdown()
}


