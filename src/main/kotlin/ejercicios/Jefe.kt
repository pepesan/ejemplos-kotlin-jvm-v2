package com.cursosdedesarrollo.kotlin.ejercicios

class Jefe(
    nombre: String = "",
    direccion: String = "",
    cargo: String = "",
    sueldo: Float = 0F,
    nombreDepartamento: String = "Dirección")
    : Empleado(nombre, direccion, cargo, sueldo) {
    var nombreDepartamento: String = nombreDepartamento
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Jefe

        return nombreDepartamento == other.nombreDepartamento
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + nombreDepartamento.hashCode()
        return result
    }

    override fun toString(): String {
        return "Jefe(nombreDepartamento='$nombreDepartamento', ${super.toString()})"
    }


}