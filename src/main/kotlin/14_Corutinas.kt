package com.cursosdedesarrollo.kotlin

import kotlinx.coroutines.*
/*
    El uso de GlobalScope se considera delicado porque
    las corutinas lanzadas con él no están vinculadas
    a un ciclo de vida específico, por eso ponemos este @OptIn
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch {
        // Simular una operación asíncrona
        delay(1000)
        println("Corutina: Operación completada después de 1 segundo")
    }

    // Imprimir un mensaje desde el hilo principal
    println("Hilo principal: Continuando con otras tareas")

    // Esperar a que la corutina termine (solo con fines de demostración, en un entorno de producción deberías gestionar mejor la sincronización)
    Thread.sleep(2000)
}