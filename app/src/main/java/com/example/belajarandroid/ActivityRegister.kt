package com.example.belajarandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        var editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogIn: Button = findViewById<Button>(R.id.btnLogIn)
        val user = intent.getStringExtra("key_username")
        val password = intent.getStringExtra("key_password")
        val fullName = intent.getStringExtra("key_fullName")
        editTextUsername.setText(user)
        editTextPassword.setText(password)


        btnLogIn.setOnClickListener()
        {
            var username = editTextUsername.text.toString()
            var password = editTextPassword.text.toString()
            val intent = Intent(this, LoggedIn::class.java)
            intent.putExtra("key_username",username)
            intent.putExtra("key_password",password)
            intent.putExtra("key_fullName",fullName)

            startActivity(intent)
            finish()
        }

    }
}