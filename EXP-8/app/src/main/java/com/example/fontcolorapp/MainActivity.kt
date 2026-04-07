package com.example.fontcolorapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.btnChange)

        button.setOnClickListener {

            // Change text color
            textView.setTextColor(Color.RED)

            // Change font style
            textView.setTypeface(null, Typeface.BOLD)

            // Show Toast
            Toast.makeText(this, "Style Changed!", Toast.LENGTH_SHORT).show()
        }
    }
}