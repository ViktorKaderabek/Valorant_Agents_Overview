package com.example.valorant_agents_informations.presentation.DetailAgentScreen.view_model.view_model_state

import com.example.valorant_agents_informations.domain.model.Agents

data class DetailAgentScreenViewModelStete(
    val Agents : Agents? = null,
    val Error : String? = null,
    val Loading : Boolean = false
)
