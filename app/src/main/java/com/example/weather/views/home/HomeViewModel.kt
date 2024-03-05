package com.example.weather.views.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weather.model.WeatherAndCityInfo
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

object HomeViewModel {

    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDate =
        LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH))
    var currentTemp: MutableState<String?> = mutableStateOf("")
    var tempMin
            : MutableState<String?> = mutableStateOf("")
    var tempMax
            : MutableState<String?> = mutableStateOf("")
    var feelsLike
            : MutableState<String?> = mutableStateOf("")
    var description: MutableState<String?> = mutableStateOf(null)
    var cityName: MutableState<String?> = mutableStateOf(null)
    var country: MutableState<String?> = mutableStateOf(null)
    var sunriseTime: MutableState<Int?> = mutableStateOf(null)
    var sunsetTime: MutableState<Int?> = mutableStateOf(null)

    fun updateWeatherDataInHomeViewModel(weatherData: WeatherAndCityInfo) {
        currentTemp.value =
            convertFahrenheitToCelsius(
                weatherData.weatherList?.firstOrNull()?.main?.temp!!
            )
        tempMin
            .value =
            convertFahrenheitToCelsius(
                weatherData.weatherList?.firstOrNull()?.main?.tempMin!!
            )
        tempMax
            .value =
            convertFahrenheitToCelsius(
                weatherData.weatherList?.firstOrNull()?.main?.tempMax!!
            )
        feelsLike
            .value =
            convertFahrenheitToCelsius(
                weatherData.weatherList?.firstOrNull()?.main?.feelsLike!!
            )
        description.value =
            weatherData.weatherList.firstOrNull()?.weather?.getOrNull(0)?.description ?: ""

//             weatherData.weatherList?.firstOrNull()?.main?.temp
        cityName.value = weatherData.city?.name
        country.value = weatherData.city?.country
        sunriseTime.value = weatherData.city?.sunrise
        sunsetTime.value = weatherData.city?.sunset
    }

    private fun convertFahrenheitToCelsius(fahrenheit: Double): String {
//        val format = DecimalFormat("0.#")
//        return format.format(fahrenheit - 273.15)
        return (fahrenheit - 273.15).roundToInt().toString()
    }

}