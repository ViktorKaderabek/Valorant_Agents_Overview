package com.example.valorant_agents_informations.domain.use_case

import com.example.valorant_agents_informations.common.Resource
import com.example.valorant_agents_informations.data.remote.dto.toAgents
import com.example.valorant_agents_informations.domain.model.Agents
import com.example.valorant_agents_informations.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAgentsDetailUseCase (
    private val repository: AgentsRepository
) {
    operator fun invoke(id : String) : Flow<Resource<Agents>> = flow{
        try{
            emit(Resource.Loading())
            val agents = repository.getAgentById(id)
            emit(Resource.Success())
        }catch (e : Exception){
            emit(Resource.Error("An Error has occurred"))
        }
    }
}