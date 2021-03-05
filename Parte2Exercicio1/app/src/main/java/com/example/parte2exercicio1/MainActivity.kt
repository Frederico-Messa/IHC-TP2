package com.example.parte2exercicio1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    private var m_sensor_manager: SensorManager? = null
    private var m_luminousmeter: Sensor? = null
    private var output_text_box: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        m_sensor_manager = getSystemService(SENSOR_SERVICE) as SensorManager
        m_luminousmeter = (m_sensor_manager ?: return).getDefaultSensor(Sensor.TYPE_LIGHT)
        output_text_box = findViewById(R.id.output_text_box)

        if (m_luminousmeter != null) {
            (m_sensor_manager ?: return).registerListener(this, m_luminousmeter, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            (output_text_box ?: return).text = "Light sensor not supported"
        }

    }

    override fun onResume() {
        super.onResume()
        (m_sensor_manager ?: return).registerListener(this, m_luminousmeter, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        (m_sensor_manager ?: return).unregisterListener(this)
    }

    override fun onSensorChanged(sensor_event: SensorEvent) {
        if (sensor_event.sensor.type == Sensor.TYPE_LIGHT) {
            (output_text_box ?: return).text = "Light Intensity: " + sensor_event.values[0] + "lux"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}