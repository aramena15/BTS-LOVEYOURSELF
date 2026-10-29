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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loveyourselfapp.ui.theme.BTSBodyFont
import com.example.loveyourselfapp.ui.theme.BTSTitleFont

private val ProfilePurpleDark = Color(0xFF250A36)
private val ProfilePurpleCard = Color(0xFF351149)
private val ProfilePurpleLight = Color(0xFF8D3FB3)
private val ProfilePink = Color(0xFFE38CFF)
private val ProfileWhite = Color(0xFFF8F3FA)
private val ProfileMuted = Color(0xFFB9A8C2)

@Composable
fun PerfilScreen(
    puntuacion: Int,
    onNavigate: (AppRoute) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ProfilePurpleDark)
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
                        color = ProfileWhite
                    )

                    Text(
                        text = "MY PROFILE",
                        fontFamily = BTSBodyFont,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.7.sp,
                        color = ProfilePink
                    )
                }

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(ProfilePink),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil",
                        tint = ProfilePurpleDark,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Your ARMY profile.",
                fontFamily = BTSTitleFont,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                color = ProfileWhite
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Your journey with BTS starts here",
                fontFamily = BTSBodyFont,
                fontSize = 11.sp,
                color = ProfileMuted
            )

            Spacer(modifier = Modifier.height(21.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ProfilePurpleCard
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(82.dp)
                            .clip(CircleShape)
                            .background(ProfilePurpleLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                                .background(ProfilePink),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "ARMY",
                                tint = ProfilePurpleDark,
                                modifier = Modifier.size(38.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "ARMY",
                            fontFamily = BTSTitleFont,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = ProfileWhite
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "BTS fan · Love Yourself",
                            fontFamily = BTSBodyFont,
                            fontSize = 10.sp,
                            color = ProfileMuted
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(ProfilePink)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "ACTIVE ARMY",
                                fontFamily = BTSBodyFont,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp,
                                color = ProfilePink
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ProfilePurpleLight
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(19.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(11.dp))
                                .background(ProfilePurpleDark.copy(alpha = 0.45f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Quiz score",
                                tint = ProfilePink,
                                modifier = Modifier.size(21.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(11.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "QUIZ SCORE",
                                fontFamily = BTSBodyFont,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.5.sp,
                                color = ProfilePink
                            )

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "$puntuacion / 5",
                                fontFamily = BTSTitleFont,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = ProfileWhite
                            )
                        }

                        Text(
                            text = if (puntuacion >= 4) {
                                "ARMY PRO"
                            } else if (puntuacion >= 3) {
                                "ARMY"
                            } else {
                                "KEEP GOING"
                            },
                            fontFamily = BTSBodyFont,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            color = ProfileWhite
                        )
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        repeat(5) { index ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(5.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(
                                        if (index < puntuacion) {
                                            ProfilePink
                                        } else {
                                            ProfilePurpleDark.copy(alpha = 0.45f)
                                        }
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ProfilePurpleCard
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(19.dp)
                ) {
                    Text(
                        text = "LOVE YOURSELF",
                        fontFamily = BTSBodyFont,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.8.sp,
                        color = ProfilePink
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "You are your own greatest love.",
                        fontFamily = BTSTitleFont,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = ProfileWhite
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Keep discovering music, memories and moments with BTS.",
                        fontFamily = BTSBodyFont,
                        fontSize = 10.sp,
                        color = ProfileMuted
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    onNavigate(AppRoute.Quiz)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ProfilePink,
                    contentColor = ProfilePurpleDark
                )
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Quiz",
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = "TAKE THE QUIZ AGAIN",
                    fontFamily = BTSBodyFont,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
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
                selected = false,
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
                selected = true,
                onClick = {
                    onNavigate(AppRoute.Perfil)
                }
            )
        }
    }
}