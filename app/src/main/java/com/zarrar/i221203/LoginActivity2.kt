package com.zarrar.i221203 // Make sure this package name matches your project

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity2 : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Example: Get references to views and set click listeners
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val tvSignUp = findViewById<TextView>(R.id.tvSignUp) // Assuming the clickable part is "Sign up."
        val tvBack = findViewById<ImageView>(R.id.tvarrow) // Assuming there's a TextView for back navigation

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            // TODO: Handle login logic
            val intent = android.content.Intent(this, HomePageActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvForgotPassword.setOnClickListener {
            // TODO: Handle forgot password
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }

        tvSignUp.setOnClickListener {

            tvSignUp.setOnClickListener { finish() } // go back to sign up
            // Example: finish() or startActivity(Intent(this, SignUpActivity::class.java))
        }
        tvBack.setOnClickListener {
            //onBackPressedDispatcher.onBackPressed() // or finish()
            finish()
        }
        // Note: The back arrow functionality at the top left is usually handled
        // by the ActionBar/Toolbar. If you enable an ActionBar:
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // supportActionBar?.setDisplayShowHomeEnabled(true)
        // Then override onOptionsItemSelected to handle android.R.id.home
    }

    // If using ActionBar/Toolbar for back navigation:
    // override fun onOptionsItemSelected(item: MenuItem): Boolean {
    //     if (item.itemId == android.R.id.home) {
    //         onBackPressedDispatcher.onBackPressed() // or finish()
    //         return true
    //     }
    //     return super.onOptionsItemSelected(item)
    // }
}
