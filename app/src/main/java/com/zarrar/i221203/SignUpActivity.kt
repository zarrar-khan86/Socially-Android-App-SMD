package com.zarrar.i221203

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.net.Uri
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import kotlin.toString

class SignUpActivity : AppCompatActivity() {

    private lateinit var etDob: EditText
    private lateinit var etPassword: EditText
    private lateinit var togglePassword: ImageButton
    private lateinit var btnCreate: Button

    private lateinit var ivCamera: ImageView
    private lateinit var etUsername: EditText
    private var selectedAvatarUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Apply system bar insets to the actual root view
       //what is root view here?
        val root = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Bind views used in basic flow
        etUsername = findViewById(R.id.etUsername)
        etDob = findViewById(R.id.etDob)
        etPassword = findViewById(R.id.etPassword)
        togglePassword = findViewById(R.id.togglePassword)
        btnCreate = findViewById(R.id.btnCreateAccount)


        // DOB picker (simple)
        etDob.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, y, m, d ->
                    val dd = "%02d".format(d)
                    val mm = "%02d".format(m + 1)
                    etDob.setText("$dd - $mm - $y")
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Password visibility toggle
        togglePassword.setOnClickListener {
            val hidden = etPassword.transformationMethod is PasswordTransformationMethod
            etPassword.transformationMethod =
                if (hidden) HideReturnsTransformationMethod.getInstance()
                else PasswordTransformationMethod.getInstance()
            etPassword.setSelection(etPassword.text.length)
        }

        // Enable button by default (no validation)
        btnCreate.isEnabled = true
        //btnCreate.setBackgroundResource(R.drawable.bg_btn_enabled)
        btnCreate.setOnClickListener {
            val username = etUsername.text?.toString().orEmpty().ifBlank { "jacob_w" }
            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("username", username)
                selectedAvatarUri?.let { putExtra("avatarUri", it.toString()) }
            }
            startActivity(intent)
            // Optionally remove SignUpActivity from back stack:
            // finish()
        }
    }
}
