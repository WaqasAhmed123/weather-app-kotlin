package com.example.weather

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.ui.theme.gradientBackground
import com.example.weather.views.detail_forecast.DetailForecastView
import com.example.weather.views.home.HomeView

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme(gradientBackground = gradientBackground) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        // Chain the background modifier with the fillMaxSize modifier
                        .then(Modifier.background(brush = gradientBackground)),
//                    color = MaterialTheme.colorScheme.background
//                            modifier = Modifier.background(brush = gradientBackground)
                ) {
                    HomeView()
//                    DetailForecastView()
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WeatherTheme {
//        Greeting("Android")
//    }
//}