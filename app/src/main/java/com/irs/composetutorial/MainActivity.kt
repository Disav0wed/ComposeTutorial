package com.irs.composetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    lateinit var loggedInUserTV : AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loggedInUserTV = findViewById(R.id.tvLoggedInUser)

        // Get username from intent
        val userName : String = intent.extras?.get("username") as String

        loggedInUserTV.text = "Welcome $userName"

    }
}