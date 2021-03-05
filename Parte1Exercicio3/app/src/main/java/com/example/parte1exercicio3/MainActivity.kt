package com.example.parte1exercicio3

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(), SensorEventListener {
    private var m_sensor_manager: SensorManager? = null
    private var m_accelerometer: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        m_sensor_manager = getSystemService(SENSOR_SERVICE) as SensorManager
        m_accelerometer = (m_sensor_manager ?: return).getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        (m_sensor_manager ?: return).registerListener(this, m_accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        (m_sensor_manager ?: return).unregisterListener(this)
    }

    override fun onSensorChanged(sensor_event: SensorEvent) {
        if (sensor_event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            findViewById<TextView>(R.id.coordinate_x_output_text_box).text = "x: " + (100*sensor_event.values[0]).roundToInt() / 100.0f
            findViewById<TextView>(R.id.coordinate_y_output_text_box).text = "y: " + (100*sensor_event.values[1]).roundToInt() / 100.0f
            findViewById<TextView>(R.id.coordinate_z_output_text_box).text = "z: " + (100*sensor_event.values[2]).roundToInt() / 100.0f
            if (sensor_event.values[0] > 15 || sensor_event.values[1] > 15 || sensor_event.values[2] > 15)
            {
                startActivity(Intent(this, MainActivity2::class.java))
            }
        }
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}