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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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

private val MusicPurpleDark = Color(0xFF250A36)
private val MusicPurpleCard = Color(0xFF351149)
private val MusicPurpleLight = Color(0xFF8D3FB3)
private val MusicPink = Color(0xFFE38CFF)
private val MusicWhite = Color(0xFFF8F3FA)
private val MusicMuted = Color(0xFFB9A8C2)

@Composable
fun DiscografiaScreen(
    onNavigate: (AppRoute) -> Unit
) {
    var canciones by remember {
        mutableStateOf<List<Cancion>>(emptyList())
    }

    var cargando by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        try {
            val respuesta = RetrofitClient.api.getCanciones()

            if (respuesta.status == "success") {
                canciones = respuesta.data ?: emptyList()
                error = false
            } else {
                error = true
            }
        } catch (e: Exception) {
            error = true
        } finally {
            cargando = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MusicPurpleDark)
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
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "BTS ARMY",
                        fontFamily = BTSTitleFont,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MusicWhite
                    )

                    Text(
                        text = "YOUR MUSIC",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.7.sp,
                        color = MusicPink
                    )
                }

                IconButton(
                    onClick = {
                        onNavigate(AppRoute.Inicio)
                    },
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(MusicPurpleCard)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Inicio",
                        tint = MusicPink,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "BTS Discography.",
                fontFamily = BTSTitleFont,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                color = MusicWhite
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Explore your favorite BTS songs",
                fontFamily = BTSBodyFont,
                fontSize = 11.sp,
                color = MusicMuted
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MusicPurpleCard)
                    .padding(horizontal = 13.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = MusicMuted,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(9.dp))

                Text(
                    text = "Search songs...",
                    fontFamily = BTSBodyFont,
                    fontSize = 11.sp,
                    color = MusicMuted
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ALL SONGS",
                    fontFamily = BTSBodyFont,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.6.sp,
                    color = MusicPink,
                    modifier = Modifier.weight(1f)
                )

                if (!cargando && !error) {
                    Text(
                        text = "${canciones.size} TRACKS",
                        fontFamily = BTSBodyFont,
                        fontSize = 9.sp,
                        color = MusicMuted
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            when {
                cargando -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(
                                color = MusicPink,
                                modifier = Modifier.size(30.dp),
                                strokeWidth = 3.dp
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "Loading music...",
                                fontFamily = BTSBodyFont,
                                fontSize = 11.sp,
                                color = MusicMuted
                            )
                        }
                    }
                }

                error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MusicPurpleCard
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(22.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Something went wrong",
                                    fontFamily = BTSTitleFont,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MusicWhite
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = "We couldn't load the BTS music.",
                                    fontFamily = BTSBodyFont,
                                    fontSize = 11.sp,
                                    color = MusicMuted
                                )
                            }
                        }
                    }
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        items(canciones) { cancion ->
                            CancionMusicCard(
                                cancion = cancion
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
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
                selected = true,
                onClick = { onNavigate(AppRoute.Discografia) }
            )

            BTSNavItem(
                icon = Icons.Default.Psychology,
                text = "Quiz",
                selected = false,
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

@Composable
private fun CancionMusicCard(
    cancion: Cancion
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clickable { },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MusicPurpleCard
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(66.dp)
                    .clip(RoundedCornerShape(11.dp))
                    .background(MusicPurpleLight),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.LibraryMusic,
                        contentDescription = "Canción",
                        tint = MusicWhite,
                        modifier = Modifier.size(22.dp)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = cancion.anio.toString(),
                        fontFamily = BTSBodyFont,
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold,
                        color = MusicWhite
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = cancion.titulo,
                    fontFamily = BTSTitleFont,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MusicWhite,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = cancion.album,
                    fontFamily = BTSBodyFont,
                    fontSize = 10.sp,
                    color = MusicMuted,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Text(
                        text = cancion.tipo,
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        color = MusicPink
                    )

                    Text(
                        text = "•",
                        fontSize = 8.sp,
                        color = MusicMuted
                    )

                    Text(
                        text = cancion.duracion,
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        color = MusicMuted
                    )

                    Text(
                        text = "•",
                        fontSize = 8.sp,
                        color = MusicMuted
                    )

                    Text(
                        text = "${cancion.popularidad}%",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        color = MusicMuted
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(MusicPink),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Reproducir",
                    tint = MusicPurpleDark,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}