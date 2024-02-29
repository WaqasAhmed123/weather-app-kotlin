package com.example.weather.domain.weather_model

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
//    val weatherType: WeatherType
//    weather type which contains icons related stuff

)
