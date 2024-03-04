package com.example.weather.services

import com.example.weather.model.WeatherAndCityInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/data/2.5/forecast?lat={lat}&lon={lon}&appid=0a0d1994bc7977871d6922c9b64a439f")
    suspend fun getWeatherAndCityInfo(
        @Path("lat") lat: Double,
        @Path("lon") lon: Double
    ): WeatherAndCityInfo
}
