package com.example.valorant_agents_informations.data.remote.dto

import com.example.valorant_agents_informations.domain.model.Agents

data class AgentsListDtoItem(
    val abilities: List<Ability>,
    val assetPath: String,
    val background: String,
    val backgroundGradientColors: List<String>,
    val bustPortrait: String,
    val characterTags: List<String>,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String,
    val role: Role,
    val uuid: String,
    val voiceLine: VoiceLine
)

fun AgentsListDtoItem.toAgents(): Agents {
    return Agents(
        abilities,
        description,
        developerName,
        displayIcon,
        displayName,
        killfeedPortrait,
        role,
        uuid
    )
}