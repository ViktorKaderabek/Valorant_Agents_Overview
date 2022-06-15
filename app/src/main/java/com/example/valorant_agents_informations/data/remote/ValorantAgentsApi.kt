package com.example.valorant_agents_informations.data.remote

import com.example.valorant_agents_informations.data.remote.dto.AgentsListDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantAgentsApi {

    @GET("/v1/agents")
    suspend fun getListOfAgents() : List<AgentsListDtoItem>

    @GET("/v1/{id}")
    suspend fun getAgentDetails(@Path("id")id : String) : AgentsListDtoItem

}