package com.example.loveyourselfapp

data class CancionesResponse(
    val status: String,
    val data: List<Cancion>?,
    val message: String?
)

data class Cancion(
    val id: Int,
    val titulo: String,
    val album: String,
    val anio: Int,
    val duracion: String,
    val tipo: String,
    val popularidad: Int
)