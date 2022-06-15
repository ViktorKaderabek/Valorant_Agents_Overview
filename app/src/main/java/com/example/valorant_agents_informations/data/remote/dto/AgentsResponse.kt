package com.example.valorant_agents_informations.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AgentsResponse(
    @SerializedName("results")
    val charactersList: List<AgentsListDtoItem>
)