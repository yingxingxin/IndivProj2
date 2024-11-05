package com.example.indivproj2

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    val modifier = Modifier
    NavHost(navController = navController, startDestination = "splash_screen") {

        composable("splash_screen") {
            SplashScreen(navController)
        }

        composable("login_screen") {
            LoginScreen(navController)
        }

        composable("register_screen") {
            RegisterScreen(navController)
        }

        composable("first_screen") {
            FirstScreen(navController)
        }

        composable("quiz_screen1") {
            QuizScreen1(navController, context)
        }

        composable("quiz_screen2") {
            QuizScreen2(navController, context)
        }

        composable("quiz_screen3") {
            QuizScreen3(navController, context)
        }

        composable("quiz_screen4") {
            QuizScreen4(navController, context)
        }

        composable("quiz_screen5") {
            QuizScreen5(navController, context)
        }

        composable("quiz_screen6") {
            QuizScreen6(navController, context)
        }

        composable("last_screen") {
            LastScreen(navController)
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    Box (contentAlignment = Alignment.Center) {
        Column (modifier = Modifier
            .padding(horizontal = 18.dp)
            .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Home Screen")

                Button(onClick = {
                    navController.navigate("second_screen")
                }) {
                    Text(text = "Go to second screen")
                }
            }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        navController.navigate("login_screen")
    }

    Box (contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.music), contentDescription = "" )
    }
}