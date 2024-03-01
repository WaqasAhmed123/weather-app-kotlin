package com.example.weather.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val PurpleToPinkGradient = Brush.linearGradient()
val gradientBackground = Brush.linearGradient(
    start = Offset.Zero,
    end = Offset.Infinite,
//    shaderStops = null, // Default value for ShaderStops
    colors = listOf(
        Color(0xFF362A84),
        Color.Magenta // You can replace with Colors.purple if you have defined it elsewhere
    ),
//    tileMode = null // Default value for TileMode
)
//)
//    colors = listOf(Purple80, Pink80),
//    start = Pair(0f, 0f),
//    end = Pair(1f, 1f)
//)