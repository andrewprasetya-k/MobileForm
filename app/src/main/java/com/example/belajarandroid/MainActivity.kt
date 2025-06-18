package com.example.belajarandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        var editTextFullname = findViewById<EditText>(R.id.editTextFullname)
        var editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        var editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        var editTextConfirmPassword = findViewById<EditText>(R.id.editTextConfirmPassword)
        //sama saja, bentuk deklarasi yg berbeda saja
        val btnLogIn: Button = findViewById<Button>(R.id.btnLogIn)
        btnLogIn.setOnClickListener()
        {
            var fullName = editTextFullname.text.toString()
            var username = editTextUsername.text.toString()
            var password = editTextPassword.text.toString()
            var confirmPassword = editTextConfirmPassword.text.toString()
            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Field cannot be empty!" , Toast.LENGTH_LONG).show()

            }
            else{
                if (confirmPassword != password){
                    Toast.makeText(this, "Password does not match" , Toast.LENGTH_LONG).show()
                }
                else {
                    val intent = Intent(this, ActivityRegister::class.java)
                    intent.putExtra("key_username",username)
                    intent.putExtra("key_password",password)
                    intent.putExtra("key_fullName",fullName)
                    Toast.makeText(this, "Account Created" , Toast.LENGTH_LONG).show()
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}