package com.example.weather.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.gradientBackground

//class HomeView {
//}
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
                Text(
                    text = "31\u00B0C",
//                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 64.sp
                )

                Text(
//                    text =  "Max ${homeViewModel.maxTemp}\u00B0  Min ${homeViewModel.minTemp}\u00B0",
                    text = "Max \u00B0  Min \u00B0",
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

            }


        }
    }

}