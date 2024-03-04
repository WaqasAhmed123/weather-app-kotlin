package com.example.weather.model

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import androidx.activity.compose.rememberLauncherForActivityResult as rememberLauncherForActivityResult1

object UserInfo {
    var lat: Double? = null
    var lon: Double? = null


    fun _requestLocationPermission(context: Context): Boolean {
        val permission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        return permission == PackageManager.PERMISSION_GRANTED
    }

   suspend fun getCurrentLocation(context: Context) {
        println("location granted ${_requestLocationPermission(context)}")
        if (_requestLocationPermission(context)) {
            try {
                val fusedLocationClient: FusedLocationProviderClient =
                    LocationServices.getFusedLocationProviderClient(context)

//                val locationTask: Task<android.location.Location> =
                    fusedLocationClient.lastLocation.

//                locationTask.
                    addOnSuccessListener { location ->
                        println("locatin inside $location")
                        try {
                            lat = location.latitude
                            lon = location.longitude
                            println("inside var $lat")
                            println("inside var $lon")
                        } catch (e: Exception) {
                           println("why not ${e.printStackTrace()}")
                        }
//                    lat = location.latitude
//                    lon = location.longitude
//                        print("inside var $lat")
//                        print("inside var $lon")
                }.addOnFailureListener { e ->
                    println("in failure listener $e")
                    e.printStackTrace()
                }
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
        }
    }
}
