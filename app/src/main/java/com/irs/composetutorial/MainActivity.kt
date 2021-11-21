package com.irs.composetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get username from intent
        val userName : String = intent.extras?.get("username") as String
        setContent {
            UserNameCard(userName)
        }
    }
}

@Composable
fun UserNameCard(userName: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentSize(align = Alignment.Center)){
        Text(text = "Welcome $userName")
    }

}


