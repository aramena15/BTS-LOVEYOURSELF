package com.example.loveyourselfapp

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
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

private val MembersPurpleDark = Color(0xFF250A36)
private val MembersPurpleCard = Color(0xFF351149)
private val MembersPurpleLight = Color(0xFF8D3FB3)
private val MembersPink = Color(0xFFE38CFF)
private val MembersWhite = Color(0xFFF8F3FA)
private val MembersMuted = Color(0xFFB9A8C2)

private data class MiembroItem(
    val nombre: String,
    val nombreReal: String,
    val posicion: String,
    val imagen: Int
)

@Composable
fun MiembrosScreen(
    onNavigate: (AppRoute) -> Unit
) {
    val miembros = listOf(
        MiembroItem("RM", "Kim Nam-joon", "Leader · Rapper", R.drawable.rm),
        MiembroItem("Jin", "Kim Seok-jin", "Vocalist", R.drawable.jin),
        MiembroItem("SUGA", "Min Yoon-gi", "Rapper · Producer", R.drawable.suga),
        MiembroItem("j-hope", "Jung Ho-seok", "Rapper · Dancer", R.drawable.jhope),
        MiembroItem("Jimin", "Park Ji-min", "Vocalist · Dancer", R.drawable.jimin),
        MiembroItem("V", "Kim Tae-hyung", "Vocalist", R.drawable.v),
        MiembroItem("Jungkook", "Jeon Jung-kook", "Vocalist · Dancer", R.drawable.jungkook)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MembersPurpleDark)
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
                        color = MembersWhite
                    )

                    Text(
                        text = "ARTISTS",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.7.sp,
                        color = MembersPink
                    )
                }

                IconButton(
                    onClick = {
                        onNavigate(AppRoute.Inicio)
                    },
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(MembersPurpleCard)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Inicio",
                        tint = MembersPink,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(23.dp))

            Text(
                text = "Meet the artists.",
                fontFamily = BTSTitleFont,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                color = MembersWhite
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Seven members · One story",
                fontFamily = BTSBodyFont,
                fontSize = 11.sp,
                color = MembersMuted
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "BTS MEMBERS",
                    fontFamily = BTSBodyFont,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp,
                    color = MembersPink,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "7 ARTISTS",
                    fontFamily = BTSBodyFont,
                    fontSize = 9.sp,
                    color = MembersMuted
                )
            }

            Spacer(modifier = Modifier.height(11.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(miembros) { miembro ->
                    MiembroMusicCard(
                        miembro = miembro,
                        onClick = {
                            onNavigate(AppRoute.Miembros)
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
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
            MiembrosNavItem(
                icon = Icons.Default.Home,
                text = "Home",
                selected = false,
                onClick = {
                    onNavigate(AppRoute.Inicio)
                }
            )

            MiembrosNavItem(
                icon = Icons.Default.LibraryMusic,
                text = "Music",
                selected = false,
                onClick = {
                    onNavigate(AppRoute.Discografia)
                }
            )

            MiembrosNavItem(
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
private fun MiembroMusicCard(
    miembro: MiembroItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MembersPurpleCard
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 11.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = miembro.imagen),
                contentDescription = miembro.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(66.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = miembro.nombre,
                    fontFamily = BTSTitleFont,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MembersWhite
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = miembro.nombreReal,
                    fontFamily = BTSBodyFont,
                    fontSize = 10.sp,
                    color = MembersMuted
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = miembro.posicion,
                    fontFamily = BTSBodyFont,
                    fontSize = 9.sp,
                    color = MembersPink
                )
            }

            Box(
                modifier = Modifier
                    .size(31.dp)
                    .clip(CircleShape)
                    .background(MembersPurpleLight.copy(alpha = 0.35f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Ver miembro",
                    tint = MembersPink,
                    modifier = Modifier.size(13.dp)
                )
            }
        }
    }
}

@Composable
private fun MiembrosNavItem(
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
            tint = if (selected) MembersPink else MembersMuted,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = text,
            fontFamily = BTSBodyFont,
            fontSize = 8.sp,
            color = if (selected) MembersPink else MembersMuted
        )
    }
}