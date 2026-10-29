package com.example.loveyourselfapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColorDarkSurface = Color(0xFF38304A)

private val LightColorScheme = lightColorScheme(
    primary = BTS_Purple,
    secondary = Rose_Pink,
    tertiary = Soft_Lilac,
    background = Warm_Cream,
    surface = Pure_White,
    onPrimary = Pure_White,
    onSecondary = Pure_White,
    onTertiary = Deep_Slate,
    onBackground = Deep_Slate,
    onSurface = Deep_Slate
)

private val DarkColorScheme = darkColorScheme(
    primary = Soft_Lilac,
    secondary = Rose_Pink,
    tertiary = BTS_Purple,
    background = Deep_Slate,
    surface = ColorDarkSurface,
    onPrimary = Deep_Slate,
    onSecondary = Pure_White,
    onTertiary = Pure_White,
    onBackground = Pure_White,
    onSurface = Pure_White
)

@Composable
fun LoveYourselfAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}