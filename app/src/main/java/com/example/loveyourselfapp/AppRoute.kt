package com.example.loveyourselfapp

sealed class AppRoute {
    object Inicio : AppRoute()
    object Miembros : AppRoute()
    object Quiz : AppRoute()
    object Discografia : AppRoute()
    object Perfil : AppRoute()
}