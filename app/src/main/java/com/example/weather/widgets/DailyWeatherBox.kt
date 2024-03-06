package com.example.weather.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weather.ui.theme.gradientBackground

@Composable
fun DailyWeatherBox(temperature: String, iconUrl: String, day: String, time: String) {
    Box(
        modifier = Modifier
            .width(82.dp)
            .height(172.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(1.dp, Color(0xFFF7CBFD), shape = RoundedCornerShape(50.dp))
            .background(brush = gradientBackground)
            .padding(horizontal = 16.dp)
//            .padding(8.dp)
//        modifier = Modifier
//            .width(82.dp)
//            .height(172.dp)
//            .background(brush = gradientBackground)
//            .clip(
//                RoundedCornerShape(50.dp)
//            )
//            .border(1.dp, color = (Color.Transparent), shape = RoundedCornerShape(50.dp))


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "$temperature°", style = MaterialTheme.typography.titleSmall)
            AsyncImage(
                model = iconUrl,
                contentDescription = null,
                modifier = Modifier.size(50.dp, 50.dp)
            )
            Text(text = day, style = MaterialTheme.typography.bodySmall)
            Text(text = time, style = MaterialTheme.typography.bodySmall)

        }

    }
}