package com.compose.hydration.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Green,
    surface = Color.Black,
    secondary = Antracit,
    onSecondary = Gray
)

private val LightColorPalette = lightColors(
    primary = Antracit,
    primaryVariant = Green,
    secondary = Green,
    secondaryVariant = Yellow,

    /*
    primaryVariant = Green,
    secondary = Green,
    secondaryVariant = Yellow,

    Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HydrationChallengeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = /*if (darkTheme) {*/
        DarkColorPalette
    /*} else {
        LightColorPalette
    }*/

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}