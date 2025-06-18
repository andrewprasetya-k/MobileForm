package com.example.belajarandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoggedIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logged_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_logged_in)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var textUser = findViewById<TextView>(R.id.textPassword)
        val btnLogIn: Button = findViewById<Button>(R.id.btnLogIn)
        val user = intent.getStringExtra("key_fullName")
        textUser.setText(user)
        btnLogIn.setOnClickListener()
        {
            val intent = Intent(this, ActivityRegister::class.java)
            startActivity(intent)
            finish()
        }
    }
}