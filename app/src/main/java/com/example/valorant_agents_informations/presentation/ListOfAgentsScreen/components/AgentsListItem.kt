package com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.valorant_agents_informations.domain.model.Agents

@Composable
fun AgentListItem(
    agents: Agents,
    onItemClick: (Agents) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable { onItemClick(agents) }
            .padding(10.dp)
    ) {
        Card(

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
        ) {
            Image(
                painter = rememberAsyncImagePainter(agents.displayIcon),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
        }
    }
}