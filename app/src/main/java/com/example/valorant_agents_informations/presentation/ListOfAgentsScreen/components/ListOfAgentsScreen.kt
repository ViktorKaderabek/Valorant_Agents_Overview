package com.example.valorant_agents_informations.presentation.ListOfAgentsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.ListOfAgentsScreen.Companion.id
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.components.AgentListItem
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.view_model.ListOfAgentsScreenViewModel
import com.example.valorant_agents_informations.presentation.Screen
import org.koin.androidx.compose.inject

class ListOfAgentsScreen() {
    companion object {
        var id: String? = null
    }
}

@Composable
fun ListOfAgentsScreen(
    navController: NavController
) {
    val viewModel by inject<ListOfAgentsScreenViewModel>()
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.Agents){ result ->
                AgentListItem(
                    agents = result,
                    onItemClick = {
                        navController.navigate(Screen.DetailAgentScreen.route + "/id")
                        id = result.uuid
                    }
                )
            }
        }
    }
}