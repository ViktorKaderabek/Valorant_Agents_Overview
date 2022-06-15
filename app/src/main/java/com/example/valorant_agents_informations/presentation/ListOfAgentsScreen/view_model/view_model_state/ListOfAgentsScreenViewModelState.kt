package com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.view_model.view_model_state

import com.example.valorant_agents_informations.domain.model.Agents

data class ListOfAgentsScreenViewModelState(
    val Agents: List<Agents> = emptyList(),
    val Error: String? = null,
    val Loading: Boolean = false
)