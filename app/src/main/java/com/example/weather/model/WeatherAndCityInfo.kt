package com.example.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherAndCityInfo(
    @SerializedName("name") val city: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("sunrise") val sunrise: Int?,
    @SerializedName("sunset") val sunset: Int?,
    @SerializedName("main") val weatherData: MutableMap<String, Any> = mutableMapOf(),
    @SerializedName("weather") val weatherDescription: MutableMap<String, Any> = mutableMapOf(),
    @SerializedName("dt_txt") val dtTxt: String
)
//{
//    companion object {
//        fun fromJson(json: Map<String, Any>): WeatherAndCityInfo {
//            return WeatherAndCityInfo(
//                city = json["name"] as String?,
//                country = json["country"] as String?,
//                sunrise = json["sunrise"] as Int?,
//                sunset = json["sunset"] as Int?,
//                weatherData = json["main"] as MutableMap<String, Any>,
//                weatherDescription = (json["weather"] as List<*>)[0] as MutableMap<String, Any>,
//                dtTxt = json["dt_txt"] as String
//            )
//        }
//    }
//}
