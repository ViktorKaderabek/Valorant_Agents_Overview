package com.example.valorant_agents_informations.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorant_agents_informations.presentation.DetailAgentScreen.DetailAgentScreen
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.ListOfAgentsScreen
import com.example.valorant_agents_informations.presentation.theme.Valorant_agents_informationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Valorant_agents_informationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ListOfAgentsScreen.route
                    ) {
                        composable(
                            route = Screen.ListOfAgentsScreen.route
                        ) {
                            ListOfAgentsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.DetailAgentScreen.route
                        ) {
                            DetailAgentScreen()
                        }

                    }
                }
            }
        }
    }
}
