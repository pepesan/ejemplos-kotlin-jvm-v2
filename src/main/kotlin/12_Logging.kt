package com.cursosdedesarrollo.kotlin

import mu.KotlinLogging
fun main() {
    println("logging")
    val logger = KotlinLogging.logger {}
    logger.trace { "This is trace log" }
    logger.debug { "This is debug log" }
    logger.info { "This is info log" }
    logger.warn { "This is warn log" }
    logger.error { "This is error log" }
}