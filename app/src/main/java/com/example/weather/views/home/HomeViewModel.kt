package com.example.weather.views.home

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

 class HomeViewModel {

    @RequiresApi(Build.VERSION_CODES.O)
    val formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH))

}