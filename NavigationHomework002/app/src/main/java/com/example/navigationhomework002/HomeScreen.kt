package com.example.navigationhomework002

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController



@Composable
fun HomeScreen(navController: NavHostController) {
    var username:String by remember { mutableStateOf("") }
    var password:String by remember { mutableStateOf("") }
    var bdate:String by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ico_tvu),
            contentDescription = "Logo Image"
        )
        TextField(
            value = username,
            onValueChange = {username=it},
            label = { Text(text = "Username") },
        )
        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Password") },
        )
        TextField(value = bdate,
            onValueChange ={bdate=it},
            label = { Text(text = "Birthday year")})
        
        val context= LocalContext.current
        Button(
            onClick = {
                if (username=="tvu" && password=="111111"){
                    navController.navigate("Second/$username,$bdate ")
                }else{
                    Toast.makeText(context,"Wrong!!!", Toast.LENGTH_SHORT).show()
                }

                /*
                1 - add two variable with state mode : username and password
                2 - complete value and onValueChange for TextField with variables
                3 - in onClick method check username = tvu and password = 111111 or not?
                4 - Toast OK or WRONG in Toast  */ },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            )
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }

    }

    fun LoginScreen(){

    }
}