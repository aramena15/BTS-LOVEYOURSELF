
package com.example.loveyourselfapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loveyourselfapp.ui.theme.BTSBodyFont
import com.example.loveyourselfapp.ui.theme.BTSTitleFont

private val QuizPurpleDark = Color(0xFF250A36)
private val QuizPurpleCard = Color(0xFF351149)
private val QuizPurpleLight = Color(0xFF8D3FB3)
private val QuizPink = Color(0xFFE38CFF)
private val QuizWhite = Color(0xFFF8F3FA)
private val QuizMuted = Color(0xFFB9A8C2)

data class Pregunta(
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String
)

@Composable
fun QuizScreen(
    onNavigate: (AppRoute) -> Unit,
    onScoreChange: (Int) -> Unit
) {
    val preguntas = remember {
        listOf(
            Pregunta(
                pregunta = "¿Cuál es el nombre real de V?",
                opciones = listOf(
                    "Kim Nam-joon",
                    "Kim Tae-hyung",
                    "Jeon Jung-kook",
                    "Park Ji-min"
                ),
                respuestaCorrecta = "Kim Tae-hyung"
            ),
            Pregunta(
                pregunta = "¿Quién es el líder de BTS?",
                opciones = listOf("Jin", "SUGA", "RM", "j-hope"),
                respuestaCorrecta = "RM"
            ),
            Pregunta(
                pregunta = "¿Cuántos integrantes tiene BTS?",
                opciones = listOf("5", "6", "7", "8"),
                respuestaCorrecta = "7"
            ),
            Pregunta(
                pregunta = "¿Cuál de estos álbumes pertenece a BTS?",
                opciones = listOf("Wings", "Divide", "Fine Line", "25"),
                respuestaCorrecta = "Wings"
            ),
            Pregunta(
                pregunta = "¿Cuál es el nombre real de SUGA?",
                opciones = listOf(
                    "Min Yoon-gi",
                    "Jung Ho-seok",
                    "Kim Seok-jin",
                    "Kim Tae-hyung"
                ),
                respuestaCorrecta = "Min Yoon-gi"
            )
        )
    }

    var preguntaActual by remember { mutableIntStateOf(0) }
    var puntuacion by remember { mutableIntStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
    var quizTerminado by remember { mutableStateOf(false) }

    val progreso = if (quizTerminado) {
        1f
    } else {
        (preguntaActual + 1).toFloat() / preguntas.size
    }

    val mensajeResultado = when (puntuacion) {
        5 -> "¡ARMY EXPERTA! 💜"
        3, 4 -> "¡ARMY DE CORAZÓN! ✨"
        else -> "¡ARMY EN DESCUBRIMIENTO! 🌷"
    }

    val descripcionResultado = when (puntuacion) {
        5 -> "¡Borahae! Conoces a BTS increíblemente bien. Tu corazón ARMY brilla con luz propia."
        3, 4 -> "¡Vas genial! Conoces muchos detalles de BTS. Sigue descubriendo más sobre tus siete estrellas."
        else -> "¡Tu aventura apenas comienza! Sigue descubriendo y disfrutando de BTS. ¡Cada día puedes aprender algo nuevo!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(QuizPurpleDark)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "BTS ARMY",
                        fontFamily = BTSTitleFont,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = QuizWhite
                    )

                    Text(
                        text = "QUIZ EXPERIENCE",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.7.sp,
                        color = QuizPink
                    )
                }

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(QuizPurpleCard),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Psychology,
                        contentDescription = "Quiz",
                        tint = QuizPink,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (quizTerminado) "Your result" else "Test your",
                        fontFamily = BTSBodyFont,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = QuizPink,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = if (quizTerminado) "ARMY Level." else "Knowledge.",
                        fontFamily = BTSTitleFont,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = QuizWhite
                    )
                }

                Text(
                    text = if (quizTerminado) {
                        "${preguntas.size}/${preguntas.size}"
                    } else {
                        "${preguntaActual + 1}/${preguntas.size}"
                    },
                    fontFamily = BTSTitleFont,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = QuizWhite
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(QuizPurpleCard)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progreso)
                        .height(5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(QuizPink)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (quizTerminado) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = QuizPurpleCard
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(66.dp)
                                    .clip(CircleShape)
                                    .background(QuizPurpleLight),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Psychology,
                                    contentDescription = "Resultado del quiz",
                                    tint = QuizPink,
                                    modifier = Modifier.size(36.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(18.dp))

                            Text(
                                text = "¡QUIZ COMPLETADO!",
                                fontFamily = BTSBodyFont,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.2.sp,
                                color = QuizPink
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "$puntuacion / ${preguntas.size}",
                                fontFamily = BTSTitleFont,
                                fontSize = 42.sp,
                                fontWeight = FontWeight.Bold,
                                color = QuizWhite
                            )

                            Text(
                                text = "respuestas correctas",
                                fontFamily = BTSBodyFont,
                                fontSize = 13.sp,
                                color = QuizMuted
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = mensajeResultado,
                                fontFamily = BTSTitleFont,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold,
                                color = QuizPink
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = descripcionResultado,
                                fontFamily = BTSBodyFont,
                                fontSize = 14.sp,
                                color = QuizWhite,
                                lineHeight = 22.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "LOVE YOURSELF 💜",
                                fontFamily = BTSTitleFont,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.5.sp,
                                color = QuizPink
                            )
                        }
                    }
                }

                Button(
                    onClick = {
                        onNavigate(AppRoute.Perfil)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = QuizPink,
                        contentColor = QuizPurpleDark
                    )
                ) {
                    Text(
                        text = "VER MI PERFIL ⭐",
                        fontFamily = BTSBodyFont,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            } else {
                val pregunta = preguntas[preguntaActual]

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = QuizPurpleCard
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "QUESTION ${preguntaActual + 1}",
                            fontFamily = BTSBodyFont,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.6.sp,
                            color = QuizPink
                        )

                        Spacer(modifier = Modifier.height(9.dp))

                        Text(
                            text = pregunta.pregunta,
                            fontFamily = BTSTitleFont,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = QuizWhite
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(9.dp)
                ) {
                    pregunta.opciones.forEachIndexed { index, opcion ->
                        val seleccionada = respuestaSeleccionada == opcion

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                                .clickable {
                                    respuestaSeleccionada = opcion
                                },
                            shape = RoundedCornerShape(13.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (seleccionada) {
                                    QuizPurpleLight
                                } else {
                                    QuizPurpleCard
                                }
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(27.dp)
                                        .clip(CircleShape)
                                        .background(
                                            if (seleccionada) {
                                                QuizPink
                                            } else {
                                                QuizPurpleDark
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = ('A'.code + index).toChar().toString(),
                                        fontFamily = BTSBodyFont,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (seleccionada) {
                                            QuizPurpleDark
                                        } else {
                                            QuizMuted
                                        }
                                    )
                                }

                                Spacer(modifier = Modifier.width(11.dp))

                                Text(
                                    text = opcion,
                                    fontFamily = BTSBodyFont,
                                    fontSize = 12.sp,
                                    fontWeight = if (seleccionada) {
                                        FontWeight.Bold
                                    } else {
                                        FontWeight.Normal
                                    },
                                    color = QuizWhite,
                                    modifier = Modifier.weight(1f)
                                )

                                RadioButton(
                                    selected = seleccionada,
                                    onClick = {
                                        respuestaSeleccionada = opcion
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        if (respuestaSeleccionada == pregunta.respuestaCorrecta) {
                            puntuacion++
                        }

                        if (preguntaActual < preguntas.lastIndex) {
                            preguntaActual++
                            respuestaSeleccionada = null
                        } else {
                            onScoreChange(puntuacion)
                            quizTerminado = true
                        }
                    },
                    enabled = respuestaSeleccionada != null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = QuizPink,
                        contentColor = QuizPurpleDark,
                        disabledContainerColor = QuizPurpleCard,
                        disabledContentColor = QuizMuted
                    )
                ) {
                    Text(
                        text = if (preguntaActual == preguntas.lastIndex) {
                            "VER MI RESULTADO"
                        } else {
                            "NEXT QUESTION"
                        },
                        fontFamily = BTSBodyFont,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .background(Color(0xFF1D072B))
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BTSNavItem(
                icon = Icons.Default.Home,
                text = "Home",
                selected = false,
                onClick = { onNavigate(AppRoute.Inicio) }
            )

            BTSNavItem(
                icon = Icons.Default.Groups,
                text = "Artists",
                selected = false,
                onClick = { onNavigate(AppRoute.Miembros) }
            )

            BTSNavItem(
                icon = Icons.Default.LibraryMusic,
                text = "Music",
                selected = false,
                onClick = { onNavigate(AppRoute.Discografia) }
            )

            BTSNavItem(
                icon = Icons.Default.Psychology,
                text = "Quiz",
                selected = true,
                onClick = { onNavigate(AppRoute.Quiz) }
            )

            BTSNavItem(
                icon = Icons.Default.Person,
                text = "Profile",
                selected = false,
                onClick = { onNavigate(AppRoute.Perfil) }
            )
        }
    }
}