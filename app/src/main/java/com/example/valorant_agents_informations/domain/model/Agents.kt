package com.example.valorant_agents_informations.domain.model

import com.example.valorant_agents_informations.data.remote.dto.Ability
import com.example.valorant_agents_informations.data.remote.dto.Role

data class Agents(
    val abilities: List<Ability>,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayName: String,
    val killfeedPortrait: String,
    val role: Role,
    val uuid: String
)
