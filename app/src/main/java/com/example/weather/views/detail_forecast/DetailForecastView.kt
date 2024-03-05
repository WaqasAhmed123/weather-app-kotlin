package com.example.weather.views.detail_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.views.home.HomeViewModel
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
//                text = "Karachi, PK",
                text = "${HomeViewModel.cityName.value}, ${HomeViewModel.country.value}",
                style = MaterialTheme.typography.titleMedium,
//                    modifier = Modifier.align(Alignment.Center),
//                color = Color.White,
//                fontSize = 64.sp
            )
            Row {
                SunTiming(sunEvent = "SUNRISE", time = "${HomeViewModel.sunriseTime.value}")
                Spacer(modifier = Modifier.width(10.dp))
                SunTiming(sunEvent = "SUNSET", time = "${HomeViewModel.sunsetTime.value}")

            }
        }


    }

}