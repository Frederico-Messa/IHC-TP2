package com.example.parte1exercicio1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun compute_addition(view: View) {
        try {
            findViewById<TextView>(R.id.sum_output_text_box).text = "Sum: " + (parseInt(findViewById<EditText>(R.id.augend_input_text_box).text.toString()) + parseInt(findViewById<EditText>(R.id.addend_input_text_box).text.toString())).toString()
        }
        catch (exception: Exception)
        {
            findViewById<TextView>(R.id.sum_output_text_box).text = "Sum: syntax error."
        }
    }
}
