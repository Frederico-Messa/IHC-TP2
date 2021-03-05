package com.example.parte2exercicio3

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.widget.Toast
import androidx.core.content.ContextCompat

class GPS_Tracker(context: Context) : LocationListener {
    private var context: Context = context

    fun get_location(): Location? {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission not granted", Toast.LENGTH_LONG).show()
            return null
        }

        val location_manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (!location_manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(context, "Please enable GPS", Toast.LENGTH_LONG).show()
            return null
        }

        location_manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10f, this)
        return location_manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
    }

    override fun onLocationChanged(location: Location) {}
}