package com.example.weather.views.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.gradientBackground

//class HomeView {
//}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeView() {

    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradientBackground),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.weather_icon), // Load drawable resource
                    contentDescription = "My Image",
                    modifier = Modifier
                        .height(198.dp) // Set height
                        .width(336.dp) // Set width
                )

                Text(

                    //                    text = "25\u00B0C",
//                    text = "${homeViewModel.currentTemp.value}\u00B0C",
//                    text = "${homeViewModel.value.currentTemp.value}\u00B0C",
                    text = "${HomeViewModel.currentTemp.value}\u00B0C",
//                    text = "$23\u00B0C",
                    //                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 64.sp
                )
                Text(
                    "${HomeViewModel.description.value}",
//                    "Cloudy",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    //                    text =  "Max ${homeViewModel.maxTemp}\u00B0  Min ${homeViewModel.minTemp}\u00B0",
                    text = "Max ${HomeViewModel.tempMax.value}\u00B0  Min ${HomeViewModel.tempMin.value}\u00B0",
                    //                    modifier = Modifier.align(Alignment.Center),
                    //                    color = Color.White,
                    //                    fontSize = 64.sp
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.house), // Load drawable resource
                    contentDescription = "My Image",
                    modifier = Modifier
                        .height(198.dp) // Set height
                        .width(336.dp) // Set width
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()// Fill available width
                        //                        .height(198.dp) // S
                        //                        .size(
                        ////                            width = 336.dp,
                        //                            height = 198.dp)
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(brush = gradientBackground)
                        .border(width = 1.dp, color = Color.Transparent),
                    //                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth(),
                            //                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Today", style = MaterialTheme.typography.titleSmall)
                            Text(
                                text = HomeViewModel.formattedDate,
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider(
                            color = Color(0xFF362A84),
                        )
                        Text(
                            "Feels Like",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            //                            add feels like here
                            "${HomeViewModel.feelsLike.value}\u00B0C",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }


                }

            }


        }
    }

}