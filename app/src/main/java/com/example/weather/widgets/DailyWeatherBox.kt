package com.example.weather.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weather.ui.theme.gradientBackground

@Composable
fun DailyWeatherContainer(temperature: String,iconUrl:String,day:String,time:String) {
    Box(
        modifier = Modifier
            .width(82.dp)
            .height(172.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(1.dp, Color(0xFFF7CBFD), shape = RoundedCornerShape(50.dp))
            .background(brush = gradientBackground)
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
        Column {
            AsyncImage(model = iconUrl, contentDescription =null )
            Text(text = "$temperature°")
            Text(text = "$day  $time")

        }

    }
}