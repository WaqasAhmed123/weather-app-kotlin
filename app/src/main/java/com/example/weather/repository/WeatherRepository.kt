package com.example.weather.repository

//import com.example.weather.views.home.homeViewModel
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.weather.model.UserInfo
import com.example.weather.model.UserInfo.lat
import com.example.weather.model.UserInfo.lon
import com.example.weather.model.WeatherAndCityInfo
import com.example.weather.services.ApiService
import com.example.weather.views.home.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRepository {

    val BASE_URL = "https://api.openweathermap.org"

//    var lat = 24.9325095
//    var lon = 67.1005537

    //        val homeViewModel = HomeViewModel()
//    var isDataLoaded = mutableStateOf(false)
//    fun getMyData(lat: Double, lon: Double) {
    fun getMyData() {
        println("location while calling func $lat, $lon")
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
        val retrofitData =
            retrofitBuilder.getWeatherAndCityInfoFromAPi(lat = UserInfo.lat!!, lon = UserInfo.lon!!)
        retrofitData.enqueue(object : Callback<WeatherAndCityInfo> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<WeatherAndCityInfo>, response: Response<WeatherAndCityInfo>
            ) {
                if (response.isSuccessful) {
                    println("rep is $response")
                    val completeWeatherData = response.body()
                    HomeViewModel.updateWeatherDataInHomeViewModel(completeWeatherData!!)


                    println("response body is ${completeWeatherData}")
//                    isDataLoaded.value = true

                } else {
                    println("Response not successful: ${response.code()}")
                }

            }

            override fun onFailure(call: Call<WeatherAndCityInfo>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.message)
            }
        })


    }
}