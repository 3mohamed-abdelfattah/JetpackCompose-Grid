package com.example.jetpackcompose_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_grid.ui.theme.JetpackComposeGridTheme
import com.example.jetpackcompose_grid.view.SampleDataPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeGridTheme {
                NavigationToPage()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigationToPage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sample_data") {
        composable("sample_data", content = { SampleDataPage(navController) })
    }
}


