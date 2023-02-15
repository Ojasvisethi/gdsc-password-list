package com.example.gdsc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnClick = findViewById<Button>(R.id.button2)
        var username = findViewById<TextView>(R.id.editTextTextEmailAddress)
        var pass = findViewById<TextView>(R.id.editTextNumberPassword)
        btnClick.setOnClickListener {
            if (username.text.toString() == "test@admin.com" && pass.text.toString() == "12345678"){
                var intent = Intent(this,MainActivity3::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong username or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}