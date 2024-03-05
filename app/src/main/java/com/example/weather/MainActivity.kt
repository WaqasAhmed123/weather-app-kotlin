package com.example.weather

//import okhttp3.Call

//import okhttp3.Response

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.weather.model.UserInfo
import com.example.weather.repository.WeatherRepository
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.views.home.HomeView

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo.getCurrentLocation(context = this)
            WeatherRepository.getMyData()
//            LaunchedEffect(key1 = Unit) {
//                getMyData()
//
//            }
//            Content()
            WeatherTheme(gradientBackground = gradientBackground) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    LaunchedEffect(Unit) {
//                    LaunchedEffect(key1 = Unit) {
//                        getMyData()
//
//                    }
//                        UserInfo.getCurrentLocation(context =this@MainActivity)
//                    }
                    HomeView()
//                    App()
//                    println("Accessed after view ${UserInfo.lat},${UserInfo.lon}")
//                    getMyData()

                }
            }
        }
    }
}

//val BASE_URL = "https://api.openweathermap.org"
//
////var lat = UserInfo.lat
////var lon = UserInfo.lon
//var lat = 24.9325095
//var lon = 67.1005537
//val homeViewModel = HomeViewModel()
//var isDataLoaded = mutableStateOf(false)
//val completeWeatherData =
//    MutableStateFlow<WeatherAndCityInfo>(WeatherAndCityInfo(city = null, weatherList = null))
//
//@OptIn(DelicateCoroutinesApi::class)
//suspend fun getMyData() {
//    println("location while calling func $lat, $lon")
//    val retrofitBuilder = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(BASE_URL)
//        .build()
//        .create(ApiService::class.java)
//    val retrofitData = retrofitBuilder.getWeatherAndCityInfoFromAPi(lat = lat!!, lon = lon!!)
//    retrofitData.enqueue(object : Callback<WeatherAndCityInfo> {
//        override fun onResponse(
//            call: Call<WeatherAndCityInfo>, response: Response<WeatherAndCityInfo>
//        ) {
//            if (response.isSuccessful) {
//                println("rep is $response")
//                GlobalScope.launch {
//                    completeWeatherData.emit(response.body()!!)
//
//                }
////                val completeWeatherData = response.body()!!
////                homeViewModel.currentTemp.value = "abc"
////                homeViewModel.updateWeatherDataInHomeViewModel(completeWeatherData)
////                homeViewModel.currentTemp.value =
////                    completeWeatherData.weatherList?.firstOrNull()?.main?.temp
//                println(" current temp is ${homeViewModel.currentTemp.value}");
//
//
//                println("response body is ${completeWeatherData.value}")
//                isDataLoaded.value = true
//
////                for (dataItem in completeWeatherData) {
////                    myDataItemList.add(dataItem)
////                }
//            } else {
//                println("Response not successful: ${response.code()}")
//            }
//
//        }
//
//        override fun onFailure(call: Call<WeatherAndCityInfo>, t: Throwable) {
//            Log.d("TAG", "onFailure: " + t.message)
//        }
//    })
//
//
//}

//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun App() {
//    if (isDataLoaded.value) {
//        HomeView()
//    }
//
//}

