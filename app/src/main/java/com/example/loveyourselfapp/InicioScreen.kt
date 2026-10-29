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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loveyourselfapp.ui.theme.BTSBodyFont
import com.example.loveyourselfapp.ui.theme.BTSTitleFont

private val PurpleDark = Color(0xFF250A36)
private val PurpleCard = Color(0xFF351149)
private val PurpleLight = Color(0xFF8D3FB3)
private val PinkLight = Color(0xFFE38CFF)
private val TextWhite = Color(0xFFF8F3FA)
private val TextMuted = Color(0xFFB9A8C2)

private data class InicioMember(
    val nombre: String,
    val imagen: Int
)

@Composable
fun InicioScreen(
    onNavigate: (AppRoute) -> Unit
) {
    val miembros = listOf(
        InicioMember("RM", R.drawable.rm),
        InicioMember("Jin", R.drawable.jin),
        InicioMember("SUGA", R.drawable.suga),
        InicioMember("j-hope", R.drawable.jhope),
        InicioMember("Jimin", R.drawable.jimin),
        InicioMember("V", R.drawable.v),
        InicioMember("Jungkook", R.drawable.jungkook)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleDark)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

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
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextWhite
                    )

                    Text(
                        text = "YOUR MUSIC EXPERIENCE",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp,
                        color = PinkLight
                    )
                }

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(PurpleCard),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritos",
                        tint = PinkLight,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Find your best music.",
                fontFamily = BTSTitleFont,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = TextWhite
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(PurpleCard)
                    .padding(horizontal = 13.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = TextMuted,
                    modifier = Modifier.size(19.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Search BTS music...",
                    fontFamily = BTSBodyFont,
                    fontSize = 12.sp,
                    color = TextMuted
                )
            }

            Spacer(modifier = Modifier.height(21.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Artists",
                    fontFamily = BTSTitleFont,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "See all",
                    fontFamily = BTSBodyFont,
                    fontSize = 10.sp,
                    color = PinkLight,
                    modifier = Modifier.clickable {
                        onNavigate(AppRoute.Miembros)
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(13.dp)
            ) {
                items(miembros) { miembro ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            onNavigate(AppRoute.Miembros)
                        }
                    ) {
                        Box(
                            modifier = Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                                .background(PurpleCard)
                                .padding(3.dp)
                        ) {
                            androidx.compose.foundation.Image(
                                painter = painterResource(id = miembro.imagen),
                                contentDescription = miembro.nombre,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = miembro.nombre,
                            fontFamily = BTSBodyFont,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextWhite
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Playlist",
                    fontFamily = BTSTitleFont,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "See all",
                    fontFamily = BTSBodyFont,
                    fontSize = 10.sp,
                    color = PinkLight,
                    modifier = Modifier.clickable {
                        onNavigate(AppRoute.Discografia)
                    }
                )
            }

            Spacer(modifier = Modifier.height(11.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(94.dp)
                    .clickable {
                        onNavigate(AppRoute.Discografia)
                    },
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PurpleCard
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(74.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(PurpleLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "BTS",
                            fontFamily = BTSTitleFont,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextWhite
                        )
                    }

                    Spacer(modifier = Modifier.width(13.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "LOVE YOURSELF",
                            fontFamily = BTSBodyFont,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = PinkLight,
                            letterSpacing = 1.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "BTS Collection",
                            fontFamily = BTSTitleFont,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextWhite
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Explore the discography",
                            fontFamily = BTSBodyFont,
                            fontSize = 10.sp,
                            color = TextMuted
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(PinkLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Reproducir",
                            tint = PurpleDark,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(78.dp)
                    .clickable {
                        onNavigate(AppRoute.Quiz)
                    },
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF44175A)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "TEST YOUR KNOWLEDGE",
                            fontFamily = BTSBodyFont,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            color = PinkLight,
                            letterSpacing = 1.2.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "How much do you know about BTS?",
                            fontFamily = BTSBodyFont,
                            fontSize = 11.sp,
                            color = TextWhite
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Quiz",
                        tint = PinkLight,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .background(Color(0xFF1D072B))
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BTSNavItem(
                icon = Icons.Default.Home,
                text = "Home",
                selected = true,
                onClick = {
                    onNavigate(AppRoute.Inicio)
                }
            )

            BTSNavItem(
                icon = Icons.Default.LibraryMusic,
                text = "Music",
                selected = false,
                onClick = {
                    onNavigate(AppRoute.Discografia)
                }
            )

            BTSNavItem(
                icon = Icons.Default.Person,
                text = "Profile",
                selected = false,
                onClick = {
                    onNavigate(AppRoute.Perfil)
                }
            )
        }
    }
}

@Composable
private fun InicioNavItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = if (selected) PinkLight else TextMuted,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = text,
            fontFamily = BTSBodyFont,
            fontSize = 8.sp,
            color = if (selected) PinkLight else TextMuted
        )
    }
}