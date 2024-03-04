package com.example.weather.services

import com.example.weather.model.WeatherAndCityInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
//    @GET("/data/2.5/forecast?lat={lat}&lon={lon}&appid=0a0d1994bc7977871d6922c9b64a439f")
    @GET("/data/2.5/forecast?appid=0a0d1994bc7977871d6922c9b64a439f")
     fun getWeatherAndCityInfoFromAPi(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Call<WeatherAndCityInfo>
}
