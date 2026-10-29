package com.example.loveyourselfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.loveyourselfapp.ui.theme.LoveYourselfAppTheme

class DiscografiaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoveYourselfAppTheme {
                DiscografiaScreen(
                    onNavigate = { ruta ->
                        when (ruta) {
                            AppRoute.Inicio -> finish()

                            AppRoute.Perfil -> {
                                startActivity(
                                    android.content.Intent(
                                        this@DiscografiaActivity,
                                        PerfilActivity::class.java
                                    )
                                )
                            }

                            AppRoute.Discografia -> {
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