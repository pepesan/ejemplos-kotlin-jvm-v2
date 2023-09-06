package com.cursosdedesarrollo.kotlin.ejercicios

data class Cliente (
    var nombre: String = "",
    var direccion: String = "",
    var tlf: String = "",
    var email: String = "",
    private var cotizacion: Float = 0F,
    var totalCotizaciones: Float = 0F
    ) {

    fun setCotizacion(cotizacion: Float = 0F){
        this.cotizacion = cotizacion
        this.totalCotizaciones+=cotizacion
    }

    fun getCotizacion(): Float{
        return this.cotizacion
    }
}