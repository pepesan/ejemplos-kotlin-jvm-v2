package com.cursosdedesarrollo.kotlin.ejercicios

open class Persona(
    var nombre: String = "",
    var direccion: String = "") {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Persona

        if (nombre != other.nombre) return false
        if (direccion != other.direccion) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + direccion.hashCode()
        return result
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', direccion='$direccion')"
    }

}