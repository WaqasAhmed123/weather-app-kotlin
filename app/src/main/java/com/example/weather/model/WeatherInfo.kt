package com.example.weather.model

data class WeatherInfo(
    val weatherData: MutableMap<String, Any> = mutableMapOf(),
    val weatherDescription: MutableMap<String, Any> = mutableMapOf(),
    val dtTxt: String
) {
    companion object {
        fun fromJson(json: Map<String, Any>): WeatherInfo {
            return WeatherInfo(
                weatherData = json["main"] as MutableMap<String, Any>,
                weatherDescription = (json["weather"] as List<*>)[0] as MutableMap<String, Any>,
                dtTxt = json["dt_txt"] as String
            )
        }
    }
}
