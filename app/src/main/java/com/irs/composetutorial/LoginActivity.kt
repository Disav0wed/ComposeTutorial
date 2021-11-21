package com.irs.composetutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp

class LoginActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            LoginCard(context = this)
        }
    }
}

@Composable
fun LoginCard(context: Context){

    var userName by rememberSaveable { mutableStateOf("") }

    Column(
        // We are using column to align our small UI elements.
        modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentSize(align = Alignment.Center)){
        TextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            placeholder = { Text(text = "Enter user name") },
        )
        Button(onClick = {
            if(userName.length >= 3){

                var mainActivityIntent = Intent(context,MainActivity::class.java)
                mainActivityIntent.putExtra("username",userName)
                context.startActivity(mainActivityIntent)
            }else{
                Toast.makeText(context,"Username must be minimum 3 characters long!",Toast.LENGTH_SHORT).show()
            }
        }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            .padding(top = Dp(25F))) {
            Text("Login")
        }
    }

}
