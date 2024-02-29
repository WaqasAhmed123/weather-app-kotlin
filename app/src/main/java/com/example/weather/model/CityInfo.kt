package com.example.weather.model

data class CityInfo(
    val city: String?,
    val country: String?,
    val sunrise: Int?,
    val sunset: Int?
) {
    companion object {
        fun fromJson(json: Map<String, Any>): CityInfo {
            return CityInfo(
                city = json["name"] as String?,
                country = json["country"] as String?,
                sunrise = json["sunrise"] as Int?,
                sunset = json["sunset"] as Int?
            )
        }
    }
}

