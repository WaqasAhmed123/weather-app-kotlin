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
    val dayWiseTemp: MutableList<MutableList<Any>> = mutableListOf()


    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDate =
        LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH))
    var currentTemp: MutableState<String?> = mutableStateOf("")
    var tempMin: MutableState<String?> = mutableStateOf("")
    var tempMax: MutableState<String?> = mutableStateOf("")
    var feelsLike: MutableState<String?> = mutableStateOf("")
    var description: MutableState<String?> = mutableStateOf(null)
    var weatherDescriptionIconUrl: MutableState<String?> = mutableStateOf(null)
    var cityName: MutableState<String?> = mutableStateOf(null)
    var country: MutableState<String?> = mutableStateOf(null)
    var sunriseTime: MutableState<String?> = mutableStateOf(null)
    var sunsetTime: MutableState<String?> = mutableStateOf(null)

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateWeatherDataInHomeViewModel(weatherData: WeatherAndCityInfo) {
        weatherDescriptionIconUrl.value = "https://openweathermap.org/img/w/${
            weatherData.weatherList?.firstOrNull()?.weather?.getOrNull(
                0
            )?.icon
        }.png";
        println("icon url is $weatherDescriptionIconUrl")

        currentTemp.value = convertFahrenheitToCelsius(
            weatherData.weatherList?.firstOrNull()?.main?.temp!!
        )
        tempMin.value = convertFahrenheitToCelsius(
            weatherData.weatherList?.firstOrNull()?.main?.tempMin!!
        )
        tempMax.value = convertFahrenheitToCelsius(
            weatherData.weatherList?.firstOrNull()?.main?.tempMax!!
        )
        feelsLike.value = convertFahrenheitToCelsius(
            weatherData.weatherList?.firstOrNull()?.main?.feelsLike!!
        )
        description.value =
            weatherData.weatherList.firstOrNull()?.weather?.getOrNull(0)?.description ?: ""

        cityName.value = weatherData.city?.name
        country.value = weatherData.city?.country
        sunriseTime.value =
            convertUnixTimestampTo12HourFormat((weatherData.city?.sunrise)!!.toLong())
        sunsetTime.value = convertUnixTimestampTo12HourFormat((weatherData.city?.sunset)!!.toLong())
        weatherData.weatherList?.forEachIndexed { index, weather ->
            if (index != 0 && index != 1) {
                // Get the icon URL
                val iconUrl =
                    "https://openweathermap.org/img/w/${weather.weather?.firstOrNull()?.icon}.png"

                // Convert temperature to Celsius
                val temperature = convertFahrenheitToCelsius(weather.main?.temp ?: 0.0)
                val (time, day) = extractTimeAndDay(weather.dtTxt ?: "")


                // Convert timestamp to 12-hour format day
//            val dayTimestamp = weather.dtTxt ?: 0 // Get the timestamp from the weather data
//            val day = convertUnixTimestampTo12HourFormat(dayTimestamp)
//            val day = convertUnixTimestampTo12HourFormat(weather.dtTxt?.toInt()?.toLong() ?: 0)

                // Create a list to hold the icon URL, temperature, and day
                val data = mutableListOf<Any>()
                data.add(iconUrl)
                data.add(temperature)
                data.add(day)
                data.add(time)
//            data.add(day)

                // Add the data list to dayWiseTemp
                dayWiseTemp.add(data)
            }

            isDataLoaded.value = true
        }
    }

    private fun convertFahrenheitToCelsius(fahrenheit: Double): String {
        return (fahrenheit - 273.15).roundToInt().toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertUnixTimestampTo12HourFormat(unixTimestamp: Long): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochSecond(unixTimestamp), ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        return dateTime.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun extractTimeAndDay(dtTxt: String): Pair<String, String> {
        // Parse the string to LocalDateTime
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        val dateTime = LocalDateTime.parse(dtTxt, formatter)

        // Extract time in 12-hour format
        val timeFormatter = DateTimeFormatter.ofPattern("hh a", Locale.ENGLISH)
        val time = dateTime.format(timeFormatter)

        // Extract day
        val dayFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        val day = dateTime.format(dayFormatter)

        return Pair(time, day)
    }

}