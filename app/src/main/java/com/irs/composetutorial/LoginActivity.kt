package com.irs.composetutorial

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener

class LoginActivity: AppCompatActivity() {

    lateinit var userNameET : EditText
    lateinit var loginBtn : AppCompatButton
    private  var userName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userNameET = findViewById(R.id.etUserName)
        loginBtn = findViewById(R.id.btnLogin)

        // Setting click listener for login
        loginBtn.setOnClickListener {
            if(userName.length >= 3){

                var mainActivityIntent = Intent(this,MainActivity::class.java)
                mainActivityIntent.putExtra("username",userName)
                startActivity(mainActivityIntent)
            }else{
                Toast.makeText(this,"Username must be minimum 3 characters long!",Toast.LENGTH_SHORT).show()
            }
        }

        // Setting edittext to listen text changes
        userNameET.addTextChangedListener {
            userName = it.toString()
        }
    }
}