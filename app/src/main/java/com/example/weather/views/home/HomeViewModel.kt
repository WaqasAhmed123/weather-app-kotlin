package com.example.weather.views.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

 class HomeViewModel:ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH))
     var currentTemp: MutableState<Double?> = mutableStateOf(null)
     var cityName: MutableState<String?> = mutableStateOf(null)
     var country: MutableState<String?> = mutableStateOf(null)
     var sunriseTime: MutableState<Int?> = mutableStateOf(null)
     var sunsetTime: MutableState<Int?> = mutableStateOf(null)


}