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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.model.UserInfo
import com.example.weather.repository.WeatherRepository
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.views.detail_forecast.DetailForecastView
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
//                    HomeView()
//                    App()
                    DetailForecastView()
//                    println("Accessed after view ${UserInfo.lat},${UserInfo.lon}")
//                    getMyData()

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_view") {
        composable(route = "home_view") {
            HomeView(navController)
        }
        composable(route = "detail_forecast_view")
//        , arguments = listOf(
//            navArgument(name = "editableDescription") {
//                type = NavType.StringType
//                defaultValue=""
//            },
//            navArgument(name = "index") {
//                type = NavType.IntType
//                defaultValue=tasks.size-1// Assuming index is an integer
//            }
//        ))
        {
//            val editableDescription=it.arguments!!.getString("editableDescription")
//            val index=it.arguments!!.getInt("index")

            DetailForecastView()
        }
    }
}
