package com.example.valorant_agents_informations.domain.repository

import com.example.valorant_agents_informations.data.remote.dto.AgentsListDtoItem

interface AgentsRepository {

    suspend fun getListOfAgents(): List<AgentsListDtoItem>

    suspend fun getAgentById(id: String): AgentsListDtoItem
}