package com.example.navigationhomework002

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationhomework002.ui.theme.NavigationHomework002Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHomework002Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    myNavigation()
                }
            }
        }
    }
}

@Composable
fun myNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.Route){
        composable(Home.Route){
            HomeScreen(navController)
        }
        composable(route = "second/{name,birthday}", arguments = listOf(navArgument("name"){type=
            NavType.StringType})){

            SecondScreen(it.arguments?.getString("name"))
            SecondScreen(it.arguments?.getInt("birthday"))
        }
    }
}
