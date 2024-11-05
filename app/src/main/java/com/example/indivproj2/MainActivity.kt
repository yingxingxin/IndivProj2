package com.example.indivproj2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.indivproj2.ui.theme.IndivProj2Theme

class MainActivity : ComponentActivity() {
    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndivProj2Theme {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFFEFB8C8))) {
                    Navigation(context)
                }
                }
            }
        }

    }
