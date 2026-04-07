package com.example.email

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val subject = findViewById<EditText>(R.id.subject)
        val message = findViewById<EditText>(R.id.message)
        val sendBtn = findViewById<Button>(R.id.sendBtn)

        sendBtn.setOnClickListener {

            val emailText = email.text.toString()
            val subjectText = subject.text.toString()
            val messageText = message.text.toString()

            // Validation
            if (emailText.isEmpty() || subjectText.isEmpty() || messageText.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Email Intent
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailText")
                putExtra(Intent.EXTRA_SUBJECT, subjectText)
                putExtra(Intent.EXTRA_TEXT, messageText)
            }

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}