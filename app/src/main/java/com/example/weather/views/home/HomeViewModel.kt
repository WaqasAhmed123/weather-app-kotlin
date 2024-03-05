package com.example.weather.views.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weather.model.WeatherAndCityInfo
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

object HomeViewModel {
    var isDataLoaded = mutableStateOf(false)


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
    var weatherDescriptionIconUrl: MutableState<String?> = mutableStateOf(null)
    var cityName: MutableState<String?> = mutableStateOf(null)
    var country: MutableState<String?> = mutableStateOf(null)
    var sunriseTime: MutableState<String?> = mutableStateOf(null)
    var sunsetTime: MutableState<String?> = mutableStateOf(null)

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateWeatherDataInHomeViewModel(weatherData: WeatherAndCityInfo) {
        weatherDescriptionIconUrl.value =
            "https://openweathermap.org/img/w/${
                weatherData.weatherList?.firstOrNull()?.weather?.getOrNull(
                    0
                )?.icon
            }.png";
        println("icon url is $weatherDescriptionIconUrl")

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
        sunriseTime.value =
            convertUnixTimestampTo12HourFormat((weatherData.city?.sunrise)!!.toLong())
        sunsetTime.value =
            convertUnixTimestampTo12HourFormat((weatherData.city?.sunset)!!.toLong())
//        sunsetTime.value = weatherData.city?.sunset
        isDataLoaded.value = true
    }

    private fun convertFahrenheitToCelsius(fahrenheit: Double): String {
//        val format = DecimalFormat("0.#")
//        return format.format(fahrenheit - 273.15)
        return (fahrenheit - 273.15).roundToInt().toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertUnixTimestampTo12HourFormat(unixTimestamp: Long): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochSecond(unixTimestamp),
            ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        return dateTime.format(formatter)
    }

}