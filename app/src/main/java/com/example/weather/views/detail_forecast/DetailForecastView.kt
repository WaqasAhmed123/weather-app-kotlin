package com.example.weather.views.detail_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.views.home.HomeViewModel
import com.example.weather.widgets.DailyWeatherBox
import com.example.weather.widgets.SunTiming

@Composable
fun DetailForecastView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackground).padding(horizontal = 16.dp)
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
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "5-days Forecasts",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyRow {
                itemsIndexed(HomeViewModel.dayWiseTemp) { index, dayData ->
                    val iconUrl = dayData[0] as String
                    val temperature =
                        dayData[1] as String // Assuming temperature is stored as String
                    val day = dayData[2] as String
                    val time = dayData[3] as String
                    println("icon inside list is $iconUrl")
                    DailyWeatherBox(
                        temperature = temperature,
                        iconUrl = iconUrl,
                        day = day,
                        time = time
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    // You can access both index and data here
                    // For example:
                    // WeatherItem(index = index, iconUrl = dayData[0] as String, temp = dayData[1] as String, day = dayData[2] as String)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))


//            HomeViewModel.weatherDescriptionIconUrl.value?.let { DailyWeatherContainer(temperature = "23", iconUrl = it, day = "Wed", time = "6 PM") }
            Row {
                SunTiming(sunEvent = "SUNRISE", time = "${HomeViewModel.sunriseTime.value}")
                Spacer(modifier = Modifier.width(10.dp))
                SunTiming(sunEvent = "SUNSET", time = "${HomeViewModel.sunsetTime.value}")

            }
        }


    }

}