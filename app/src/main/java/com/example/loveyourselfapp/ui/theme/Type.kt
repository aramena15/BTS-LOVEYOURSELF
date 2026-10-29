package com.example.loveyourselfapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val BTSTitleFont = FontFamily.Serif

val BTSBodyFont = FontFamily.SansSerif

val Typography = Typography(

    headlineLarge = TextStyle(
        fontFamily = BTSTitleFont,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 44.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = BTSTitleFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 36.sp
    ),

    titleLarge = TextStyle(
        fontFamily = BTSBodyFont,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = BTSBodyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = BTSBodyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    labelLarge = TextStyle(
        fontFamily = BTSBodyFont,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    )
)