package com.zarrar.i221203

import android.content.Intent // Make sure Intent is imported
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val root = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val btnLogin = findViewById<Button>(R.id.btnLogin) // This is your login button
        val tvSwitch = findViewById<TextView>(R.id.tvSwitchAccounts)
        val tvSignUp = findViewById<TextView>(R.id.tvSignup)

        // Populate from intent extras
        tvUsername.text = intent.getStringExtra("username") ?: "jacob_w"
        intent.getStringExtra("avatarUri")?.let { ivAvatar.setImageURI(Uri.parse(it)) }

        btnLogin.setOnClickListener {
            // CORRECTED ACTION: Start LoginActivity2
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent)
        }

        tvSwitch.setOnClickListener {
            Toast.makeText(this, "Switch accounts tapped", Toast.LENGTH_SHORT).show()
        }

        tvSignUp.setOnClickListener {
            finish() // go back to sign up (assuming this is MainActivity or similar)
        }
    }
}
