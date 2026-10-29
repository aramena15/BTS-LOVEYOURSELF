package com.example.loveyourselfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.loveyourselfapp.ui.theme.LoveYourselfAppTheme

class PerfilActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var puntuacion by mutableIntStateOf(
            intent.getIntExtra("puntuacion", 0)
        )

        setContent {
            LoveYourselfAppTheme {
                PerfilScreen(
                    puntuacion = puntuacion,
                    onNavigate = { ruta ->
                        when (ruta) {
                            AppRoute.Inicio -> finish()

                            AppRoute.Discografia -> {
                                startActivity(
                                    android.content.Intent(
                                        this@PerfilActivity,
                                        DiscografiaActivity::class.java
                                    )
                                )
                            }

                            AppRoute.Perfil -> {
                            }

                            AppRoute.Miembros -> {
                                finish()
                            }

                            AppRoute.Quiz -> {
                                finish()
                            }
                        }
                    }
                )
            }
        }
    }
}