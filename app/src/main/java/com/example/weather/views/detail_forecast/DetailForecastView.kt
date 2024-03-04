package com.example.weather.views.detail_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.widgets.SunTiming

@Composable
fun DetailForecastView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackground)
    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {


            Text(
                text = "Karachi, PK",
                style = MaterialTheme.typography.titleMedium,
//                    modifier = Modifier.align(Alignment.Center),
//                color = Color.White,
//                fontSize = 64.sp
            )
            SunTiming(sunEvent = "Sun Rise", time ="06:35" )
        }


    }

}