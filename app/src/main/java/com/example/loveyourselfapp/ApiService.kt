    package com.example.loveyourselfapp

    import retrofit2.http.GET

    interface ApiService {

        @GET("canciones.php")
        suspend fun getCanciones(): CancionesResponse
    }
