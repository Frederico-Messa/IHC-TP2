package com.example.parte2exercicio3

import android.Manifest
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val location_information_getter_button = findViewById<Button>(R.id.location_information_getter_button)

        ActivityCompat.requestPermissions(this, Array(123) { Manifest.permission.ACCESS_FINE_LOCATION }, 123)

        val lf = {view: View ->
                val gps_tracker = GPS_Tracker(applicationContext)
                val location = gps_tracker.get_location() as Location?
                if (location != null) {
                    Toast.makeText(
                        applicationContext,
                        "Lat.: " + (location.latitude * 10000).toInt() / 10000.0f + "   Long.: " + (location.longitude * 10000).toInt() / 10000.0f,
                        Toast.LENGTH_LONG
                    ).show();
                }
            }

        location_information_getter_button.setOnClickListener(lf)
    }
}