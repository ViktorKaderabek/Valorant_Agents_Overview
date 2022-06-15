package com.example.valorant_agents_informations.presentation

sealed class Screen(val route: String) {
    object ListOfAgentsScreen : Screen("list_of_agent_screen")
    object DetailAgentScreen : Screen("detail_agent_screen")
}