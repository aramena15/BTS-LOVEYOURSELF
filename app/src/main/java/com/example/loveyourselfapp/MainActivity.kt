package com.example.loveyourselfapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.loveyourselfapp.ui.theme.LoveYourselfAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoveYourselfAppTheme {

                var ruta by remember {
                    mutableStateOf<AppRoute>(AppRoute.Inicio)
                }

                var puntuacion by remember {
                    mutableIntStateOf(0)
                }

                when (ruta) {

                    AppRoute.Inicio -> {
                        InicioScreen(
                            onNavigate = { nuevaRuta ->
                                when (nuevaRuta) {
                                    AppRoute.Perfil -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            PerfilActivity::class.java
                                        )
                                        intent.putExtra("puntuacion", puntuacion)
                                        startActivity(intent)
                                    }

                                    AppRoute.Discografia -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            DiscografiaActivity::class.java
                                        )
                                        startActivity(intent)
                                    }

                                    else -> {
                                        ruta = nuevaRuta
                                    }
                                }
                            }
                        )
                    }

                    AppRoute.Miembros -> {
                        MiembrosScreen(
                            onNavigate = { nuevaRuta ->
                                when (nuevaRuta) {
                                    AppRoute.Perfil -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            PerfilActivity::class.java
                                        )
                                        intent.putExtra("puntuacion", puntuacion)
                                        startActivity(intent)
                                    }

                                    AppRoute.Discografia -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            DiscografiaActivity::class.java
                                        )
                                        startActivity(intent)
                                    }

                                    else -> {
                                        ruta = nuevaRuta
                                    }
                                }
                            }
                        )
                    }

                    AppRoute.Quiz -> {
                        QuizScreen(
                            onNavigate = { nuevaRuta ->
                                when (nuevaRuta) {
                                    AppRoute.Perfil -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            PerfilActivity::class.java
                                        )
                                        intent.putExtra("puntuacion", puntuacion)
                                        startActivity(intent)
                                    }

                                    AppRoute.Discografia -> {
                                        val intent = Intent(
                                            this@MainActivity,
                                            DiscografiaActivity::class.java
                                        )
                                        startActivity(intent)
                                    }

                                    else -> {
                                        ruta = nuevaRuta
                                    }
                                }
                            },
                            onScoreChange = {
                                puntuacion = it
                            }
                        )
                    }

                    AppRoute.Discografia -> {
                        ruta = AppRoute.Inicio
                    }

                    AppRoute.Perfil -> {
                        ruta = AppRoute.Inicio
                    }
                }
            }
        }
    }
}