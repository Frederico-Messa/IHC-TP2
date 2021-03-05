package com.example.parte1exercicio2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun send_text(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("text_to_send", findViewById<EditText>(R.id.input_text_box).text.toString())
        startActivity(intent)
    }
}