package com.example.jetpackcompose_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose_grid.response.SampleDataClass
import com.example.jetpackcompose_grid.ui.theme.JetpackComposeGridTheme
import com.example.jetpackcompose_grid.view.SampleDataDetailPage
import com.example.jetpackcompose_grid.view.SampleDataPage
import com.google.gson.Gson

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
        composable("sample_data") { SampleDataPage(navController) }
        composable(
            "sample_data_detail/{item}",
            arguments = listOf(navArgument("item") { type = NavType.StringType })
        ) { navbackStackEntry ->
            navbackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, SampleDataClass::class.java)
                SampleDataDetailPage(data = item)
            }
        }
    }
}


