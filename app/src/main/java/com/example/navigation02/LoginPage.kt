package com.example.navigation02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {

    lateinit var login_email: EditText
    lateinit var login_password: EditText
    lateinit var login_button: Button
    lateinit var forgot_password: TextView
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        login_email = findViewById(R.id.login_email)
        login_password = findViewById(R.id.login_password)
        login_button = findViewById(R.id.login_button)
        forgot_password = findViewById(R.id.forgot_password)



        login_button.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()

            if (email.isEmpty()) {
                login_email.error = "Please Enter Mail Id !"
                login_email.requestFocus()
                return@setOnClickListener

            } else if (!email.matches(emailPattern.toRegex())) {
                login_email.error = "Please Vaild Mail Id !"
                login_email.requestFocus()
                return@setOnClickListener


            } else if (password.isEmpty() || password.length != 15) {
                login_password.error = "Please enter Password 15 digit Password  !"
                login_password.requestFocus()
                return@setOnClickListener


            } else {
                intent = Intent(this@LoginPage, HomePage::class.java)
                startActivity(intent)
            }

        }


    }
}