package com.example.valorant_agents_informations.data.repository

import com.example.valorant_agents_informations.data.remote.ValorantAgentsApi
import com.example.valorant_agents_informations.data.remote.dto.AgentsListDtoItem
import com.example.valorant_agents_informations.domain.repository.AgentsRepository

class AgentsRepositroyImpl(
    private val api: ValorantAgentsApi
) : AgentsRepository {

    override suspend fun getListOfAgents(): List<AgentsListDtoItem> {
        return api.getListOfAgents()
    }

    override suspend fun getAgentById(id: String): AgentsListDtoItem {
        return api.getAgentDetails(id)
    }
}