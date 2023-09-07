package com.cursosdedesarrollo.kotlin.ejercicios

import com.cursosdedesarrollo.kotlin.Madre

open class Empleado(
    nombre: String = "",
    direccion: String = "",
    cargo: String = "",
    sueldo: Float = 0F): Persona(nombre, direccion) {

    var cargo: String = cargo
    var sueldo: Float = sueldo
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Empleado

        if (cargo != other.cargo) return false
        if (sueldo != other.sueldo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + cargo.hashCode()
        result = 31 * result + sueldo.hashCode()
        return result
    }

    override fun toString(): String {
        return "Empleado(cargo='$cargo', sueldo=$sueldo, ${super.toString()})"
    }


}
